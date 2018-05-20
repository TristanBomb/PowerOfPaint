package tristanbomb.powerofpaint.block.paint

import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.init.SoundEvents
import net.minecraft.block.SoundType
import net.minecraft.block.state.IBlockState
import net.minecraft.util.math.AxisAlignedBB
import tristanbomb.powerofpaint.block.BlockBase

abstract class PaintBase(name: String): BlockBase(Material.SNOW, name) {
    val PAINT_AABB = AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0)
    val PAINT_SOUND = SoundType(1.0f, 0.5f, SoundEvents.BLOCK_SLIME_BREAK, SoundEvents.BLOCK_SAND_STEP, SoundEvents.BLOCK_SLIME_PLACE, SoundEvents.BLOCK_SLIME_HIT, SoundEvents.BLOCK_SLIME_FALL)

    init {
        this.blockSoundType = PAINT_SOUND
    }

    override fun isReplaceable(worldIn: IBlockAccess, pos: BlockPos) = true
    override fun isPassable(worldIn: IBlockAccess, pos: BlockPos) = false
    override fun isFullCube(state: IBlockState) = false
    override fun isOpaqueCube(state: IBlockState) = false
    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos) = PAINT_AABB
    override fun canHarvestBlock(world: IBlockAccess, pos: BlockPos, player: EntityPlayer) = false
}