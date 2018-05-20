package tristanbomb.powerofpaint

import tristanbomb.powerofpaint.block.BlockBase
import tristanbomb.powerofpaint.block.paint.PaintPropulsion
import tristanbomb.powerofpaint.block.paint.PaintRepulsion
import tristanbomb.powerofpaint.entity.EntityWaterBomb
import tristanbomb.powerofpaint.item.ItemBase
import tristanbomb.powerofpaint.item.WaterBomb

object ModObjects {
    var blocks: Array<BlockBase> = arrayOf(
        PaintRepulsion(),
        PaintPropulsion()
    )
    var items: Array<ItemBase> = arrayOf(
        WaterBomb()
    )
}