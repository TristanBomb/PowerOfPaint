package tristanbomb.powerofpaint

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.Logger
import tristanbomb.powerofpaint.proxy.CommonProxy

@Suppress("MemberVisibilityCanBePrivate")
@Mod(   modid = PowerOfPaint.MOD_ID,
        name = PowerOfPaint.NAME,
        version = PowerOfPaint.VERSION,
        acceptedMinecraftVersions = "[1.12.2]",
        dependencies = "required-after:forgelin;",
        modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")

object PowerOfPaint {
    const val MOD_ID = "powerofpaint"
    const val NAME = "Power Of Paint"
    const val VERSION = "1.12.2-0.0.0"

    lateinit var logger: Logger

    @SidedProxy(clientSide = "tristanbomb.powerofpaint.proxy.ClientProxy", serverSide = "tristanbomb.powerofpaint.proxy.ServerProxy")
    var proxy = CommonProxy()


    @Mod.EventHandler
    fun preInit(e: FMLPreInitializationEvent) {
        this.logger = e.modLog
        proxy.preInit(e)
    }
    @Mod.EventHandler
    fun init(e: FMLInitializationEvent) {
        proxy.init(e)
    }
    @Mod.EventHandler
    fun postInit(e: FMLPostInitializationEvent) {
        proxy.postInit(e)
    }

    fun trace(message: String)  { logger.log(Level.TRACE, message) }
    fun debug(message: String)  { logger.log(Level.DEBUG, message) }
    fun info (message: String)  { logger.log(Level.INFO, message) }
    fun warn (message: String)  { logger.log(Level.WARN, message) }
    fun error(message: String)  { logger.log(Level.ERROR, message) }
    fun fatal(message: String)  { logger.log(Level.FATAL, message) }
}