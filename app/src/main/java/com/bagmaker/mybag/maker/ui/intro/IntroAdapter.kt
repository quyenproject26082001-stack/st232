package com.bagmaker.mybag.maker.ui.intro

import android.content.Context
import com.bagmaker.mybag.maker.core.base.BaseAdapter
import com.bagmaker.mybag.maker.core.extensions.loadImage
import com.bagmaker.mybag.maker.core.extensions.select
import com.bagmaker.mybag.maker.core.extensions.strings
import com.bagmaker.mybag.maker.data.model.IntroModel
import com.bagmaker.mybag.maker.databinding.ItemIntroBinding

class IntroAdapter(val context: Context) : BaseAdapter<IntroModel, ItemIntroBinding>(
    ItemIntroBinding::inflate
) {
    override fun onBind(binding: ItemIntroBinding, item: IntroModel, position: Int) {
        binding.apply {
            loadImage(root, item.image, imvImage, false)
            tvContent.text = context.strings(item.content)
            tvContent.select()
        }
    }
}