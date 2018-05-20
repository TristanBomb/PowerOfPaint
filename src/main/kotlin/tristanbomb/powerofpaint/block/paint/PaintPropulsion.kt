package tristanbomb.powerofpaint.block.paint

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class PaintPropulsion: PaintBase("paint_propulsion") {
    override fun onEntityWalk(worldIn: World?, pos: BlockPos?, entityIn: Entity?) {
        if (entityIn is EntityLivingBase) {
            var boost = 0.6
            if (entityIn.isSprinting) {
                boost = 0.8
            }
            val theta = Math.atan2(entityIn.motionX, entityIn.motionZ)
            var speed = Math.sqrt(Math.pow(entityIn.motionX, 2.0) + Math.pow(entityIn.motionZ, 2.0))
            speed += boost * speed
            entityIn.motionX = speed * Math.sin(theta)
            entityIn.motionZ = speed * Math.cos(theta)
        }
        super.onEntityWalk(worldIn, pos, entityIn)
    }
}