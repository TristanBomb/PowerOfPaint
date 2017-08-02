package com.tristanbomb.powerofpaint.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPaintbomb extends EntityThrowable
{
    public EntityPaintbomb(World worldIn)
    {
        super(worldIn);
    }

    public EntityPaintbomb(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityPaintbomb(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesPaintball(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Paintbomb");
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 0;

            if (result.entityHit instanceof EntityBlaze)
            {
                i = 3;
            }

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
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