package tristanbomb.powerofpaint.entity

import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.projectile.EntityThrowable
import net.minecraft.util.EnumParticleTypes
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.RayTraceResult
import net.minecraft.world.World
import java.util.ArrayList
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity
import tristanbomb.powerofpaint.PowerOfPaint
import kotlin.math.roundToInt


class EntityWaterBomb: EntityThrowable {
    val vRadius = 1
    val hRadius = 3
    constructor(worldIn: World) : super(worldIn) {}
    constructor(worldIn: World, throwerIn: EntityLivingBase) : super(worldIn, throwerIn) {}
    constructor(worldIn: World, x: Double, y: Double, z: Double) : super(worldIn, x, y, z) {}

    companion object {
        val resourceName = "water_bomb"
        val properName = "WaterBomb"
        @JvmStatic
        fun register(id: Int) {
            registerModEntity(ResourceLocation(PowerOfPaint.MOD_ID + ":" + resourceName), EntityWaterBomb::class.java, properName, id, PowerOfPaint, 64, 10, true)
        }
    }


    override fun onImpact(result: RayTraceResult) {
        val checkArray = ArrayList<BlockPos>()
        PowerOfPaint.info(result.toString())

        if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
            for (i in -vRadius..vRadius) { //Generate a list of block positions in a cylinder
                for (j in -hRadius..hRadius) {
                    for (k in -hRadius..hRadius) {
                        if (Math.pow(j.toDouble(), 2.0) + Math.pow(k.toDouble(), 2.0) < Math.pow(hRadius + 0.5, 2.0)) {
                            val x = (result.blockPos.x) + j
                            val y = (result.blockPos.y) + i
                            val z = (result.blockPos.z) + k
                            checkArray.add(BlockPos(x, y, z))

                            this.world.spawnParticle(EnumParticleTypes.CLOUD, x + 0.5, y + 0.5, z + 0.5, 0.0, 0.0, 0.0, 10, 10, 10)
                        }
                    }
                }
            }

            for (i in checkArray.indices) {
                val bp = checkArray[i]
                if (world.getBlockState(bp).block.isReplaceable(world, bp) && !world.getBlockState(bp).material.isLiquid) {
                    world.setBlockToAir(bp)
                }
            }

            for (j in 0..10) {
                this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, 500, 500, 500)
            }

            if (!this.world.isRemote) {
                this.setDead()
            }
        }
    }
}
