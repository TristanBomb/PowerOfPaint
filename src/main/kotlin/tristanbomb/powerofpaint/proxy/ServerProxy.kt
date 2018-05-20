package tristanbomb.powerofpaint.proxy

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.relauncher.Side
import tristanbomb.powerofpaint.PowerOfPaint

@Mod.EventBusSubscriber(Side.SERVER)
class ServerProxy : CommonProxy() {
    override fun preInit(e: FMLPreInitializationEvent) {
        PowerOfPaint.debug("Pre-init for ServerProxy")
    }
    override fun init(e: FMLInitializationEvent) {
        PowerOfPaint.debug("Init for ServerProxy")
    }
    override fun postInit(e: FMLPostInitializationEvent) {
        PowerOfPaint.debug("Post-init for ServerProxy")
    }
}

