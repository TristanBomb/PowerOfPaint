package tristanbomb.powerofpaint.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import tristanbomb.powerofpaint.PowerOfPaint

abstract class BlockBase(mat: Material, name: String): Block(mat) {
    init {
        setRegistryName(name)
        unlocalizedName = PowerOfPaint.MOD_ID + "." + name
    }
    @SideOnly(Side.CLIENT)
    fun initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, ModelResourceLocation(registryName!!, "inventory"))
    }
}