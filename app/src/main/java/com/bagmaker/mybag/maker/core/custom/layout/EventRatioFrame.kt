package com.bagmaker.mybag.maker.core.custom.layout

import android.widget.ImageView
import com.bagmaker.mybag.maker.core.custom.imageview.StrokeImageView

interface EventRatioFrame {
    fun onImageClick(image: StrokeImageView, btnEdit: ImageView)
}