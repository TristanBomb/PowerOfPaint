package com.tristanbomb.powerofpaint.entity;

import java.util.ArrayList;
import java.util.List;

import com.tristanbomb.powerofpaint.EnumPaintTypes;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPaintbomb extends EntityThrowable
{
	int VRADIUS = 1;
	int HRADIUS = 2;
	
	int meta = 0;
	
    public EntityPaintbomb(World worldIn)
    {
        super(worldIn);
    }

    public EntityPaintbomb(World worldIn, EntityLivingBase throwerIn, int meta)
    {
        super(worldIn, throwerIn);
        this.meta = meta;
    }

    public EntityPaintbomb(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesPaintbomb(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Snowball");
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @SuppressWarnings("deprecation")
	protected void onImpact(RayTraceResult result)
    {
        List<BlockPos> checkArray = new ArrayList<BlockPos>();
        
        for (int i = -VRADIUS; i <= VRADIUS; i++) { //Generate a list of block positions in a cylinder
			for (int j = -HRADIUS; j <= HRADIUS; j++) {
				for (int k = -HRADIUS; k <= HRADIUS; k++) {
					if (Math.pow(j,2) + Math.pow(k,2) < Math.pow(HRADIUS+0.5,2)) {
						int x = result.getBlockPos().getX() + j;
						int y = result.getBlockPos().getY() + i;
						int z = result.getBlockPos().getZ() + k;
						
						BlockPos bp = new BlockPos(x,y,z);
						checkArray.add(bp);
					}
				}
			}
		}
        
        IBlockState state = EnumPaintTypes.getByMeta(meta).getPaint().getDefaultState();
        
        for (int i = 0; i < checkArray.size(); i++) {
			BlockPos bp = checkArray.get(i);
        	System.out.println(world.getBlockState(bp));
        	System.out.println(world.getBlockState(bp).getMaterial().isReplaceable());
        	System.out.println(world.getBlockState(bp.down()).isTopSolid());
        	
			if (world.getBlockState(bp).getMaterial().isReplaceable() && world.getBlockState(bp.down()).isTopSolid()) {
				world.setBlockState(bp, state);
			}
		}
        
        for (int j = 0; j < 8; ++j)
        {
            this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.world.isRemote)
        {
            this.setDead();
        }
    }
}