package com.bagmaker.mybag.maker.ui.add_character.adapter

import com.bagmaker.mybag.maker.core.base.BaseAdapter
import com.bagmaker.mybag.maker.core.extensions.loadImage
import com.bagmaker.mybag.maker.core.extensions.loadImageSticker
import com.bagmaker.mybag.maker.core.extensions.tap
import com.bagmaker.mybag.maker.data.model.SelectedModel
import com.bagmaker.mybag.maker.databinding.ItemStickerBinding

class StickerAdapter : BaseAdapter<SelectedModel, ItemStickerBinding>(ItemStickerBinding::inflate) {
    var onItemClick : ((String) -> Unit) = {}
    override fun onBind(binding: ItemStickerBinding, item: SelectedModel, position: Int) {
        binding.apply {
            loadImageSticker(root, item.path, imvSticker)
            root.tap { onItemClick.invoke(item.path) }
        }
    }
}