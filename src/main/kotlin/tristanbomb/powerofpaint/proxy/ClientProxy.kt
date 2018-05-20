package tristanbomb.powerofpaint.proxy

import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import tristanbomb.powerofpaint.PowerOfPaint
import tristanbomb.powerofpaint.ModObjects

@Mod.EventBusSubscriber(Side.CLIENT)
class ClientProxy : CommonProxy() {
    override fun preInit(e: FMLPreInitializationEvent) {
        super.preInit(e)
    }

    override fun init(e: FMLInitializationEvent) {
        super.init(e)

    }
    override fun postInit(e: FMLPostInitializationEvent) {
        super.postInit(e)
    }

    @SubscribeEvent
    open fun registerModels(e: ModelRegistryEvent) {
        for (i in ModObjects.blocks) {
            i.initModel()
        }
        for (i in ModObjects.items) {
            i.initModel()
        }
    }
}

