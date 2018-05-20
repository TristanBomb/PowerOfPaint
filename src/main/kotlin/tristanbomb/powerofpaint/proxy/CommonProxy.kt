package tristanbomb.powerofpaint.proxy

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import tristanbomb.powerofpaint.PowerOfPaint
import tristanbomb.powerofpaint.ModObjects
import tristanbomb.powerofpaint.entity.EntityWaterBomb

@Mod.EventBusSubscriber
open class CommonProxy {
    open fun preInit(e: FMLPreInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this)
    }

    open fun init(e: FMLInitializationEvent) {
    }

    open fun postInit(e: FMLPostInitializationEvent) {
    }

    @SubscribeEvent
    open fun registerBlocks(e: RegistryEvent.Register<Block>) {
        for (i in ModObjects.blocks) {
            e.registry.register(i)
            registerEntities()
        }
    }

    @SubscribeEvent
    open fun registerItems(e: RegistryEvent.Register<Item>) {
        for (i in ModObjects.items) {
            e.registry.register(i)
        }
        for (i in ModObjects.blocks) {
            e.registry.register(ItemBlock(i).setRegistryName(i.registryName))
        }
    }

    open fun registerEntities() {
        EntityWaterBomb.register(0)
    }
}