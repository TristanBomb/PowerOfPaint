package tristanbomb.powerofpaint.item

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import tristanbomb.powerofpaint.PowerOfPaint

abstract class ItemBase(name: String): Item() {
    init {
        setRegistryName(name)
        unlocalizedName = PowerOfPaint.MOD_ID + "." + name
    }
    @SideOnly(Side.CLIENT)
    fun initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, ModelResourceLocation(registryName!!, "inventory"))
    }
}