package tristanbomb.powerofpaint.block.paint

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.init.SoundEvents
import net.minecraft.world.World


class PaintRepulsion: PaintBase("paint_repulsion") {
    override fun onLanded(worldIn: World, entityIn: Entity) {
        if (entityIn.motionY < -0.2f && entityIn is EntityLivingBase) {
            var yvel = -1.2 * entityIn.motionY
            if (yvel < 0.8f) {
                yvel = 0.8
            }

            entityIn.fallDistance = 0.0f
            super.onLanded(worldIn, entityIn)

            if (!entityIn.isSneaking()) {
                entityIn.motionY = yvel
                entityIn.playSound(SoundEvents.BLOCK_SLIME_BREAK, yvel.toFloat() * 0.80f, yvel.toFloat())
                entityIn.playSound(SoundEvents.BLOCK_ANVIL_PLACE, yvel.toFloat() * 0.05f, yvel.toFloat() - 1)
                entityIn.motionX *= 4.0 * Math.pow(yvel, 2.0)
                entityIn.motionZ *= 4.0 * Math.pow(yvel, 2.0)
            } else {
                entityIn.playSound(SoundEvents.BLOCK_SLIME_BREAK, 0.4f, 0.0f)
                entityIn.playSound(SoundEvents.BLOCK_ANVIL_PLACE, 0.1f, -1.0f)
            }
        } else {
            super.onLanded(worldIn, entityIn)
        }
    }
}