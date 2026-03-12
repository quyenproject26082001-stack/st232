package com.bagmaker.mybag.maker.ui.choose_character

import com.bagmaker.mybag.maker.core.base.BaseAdapter
import com.bagmaker.mybag.maker.core.extensions.gone
import com.bagmaker.mybag.maker.core.extensions.loadImage
import com.bagmaker.mybag.maker.core.extensions.tap
import com.bagmaker.mybag.maker.data.model.custom.CustomizeModel
import com.bagmaker.mybag.maker.databinding.ItemChooseAvatarBinding

class ChooseCharacterAdapter : BaseAdapter<CustomizeModel, ItemChooseAvatarBinding>(ItemChooseAvatarBinding::inflate) {
    var onItemClick: ((position: Int) -> Unit) = {}
    override fun onBind(binding: ItemChooseAvatarBinding, item: CustomizeModel, position: Int) {
        binding.apply {
            loadImage(item.avatar, imvImage, onDismissLoading = {
                sflShimmer.stopShimmer()
                sflShimmer.gone()
            })
            root.tap { onItemClick.invoke(position) }
        }
    }
}