package tristanbomb.powerofpaint.item

import net.minecraft.util.EnumActionResult
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.stats.StatList
import tristanbomb.powerofpaint.entity.EntityWaterBomb
import net.minecraft.util.SoundCategory
import net.minecraft.init.SoundEvents
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.util.EnumHand
import net.minecraft.world.World

class WaterBomb: ItemBase("water_bomb") {
    override fun onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
        val itemstack = playerIn.getHeldItem(handIn)

        if (!playerIn.capabilities.isCreativeMode) {
            itemstack.shrink(1)
        }

        worldIn?.playSound(null as EntityPlayer?, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (Item.itemRand.nextFloat() * 0.4f + 0.8f))

        if (!worldIn!!.isRemote) {
            val proj = EntityWaterBomb(worldIn, playerIn)
            proj.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 1.5f, 1.0f)
            worldIn.spawnEntity(proj)
        }

        playerIn.addStat(StatList.getObjectUseStats(this))
        return ActionResult(EnumActionResult.SUCCESS, itemstack)
    }
}