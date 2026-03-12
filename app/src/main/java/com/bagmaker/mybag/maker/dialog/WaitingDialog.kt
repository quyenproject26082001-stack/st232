package com.bagmaker.mybag.maker.dialog

import android.app.Activity
import android.graphics.drawable.AnimationDrawable
import com.bagmaker.mybag.maker.R
import com.bagmaker.mybag.maker.core.base.BaseDialog
import com.bagmaker.mybag.maker.core.extensions.setBackgroundConnerSmooth
import com.bagmaker.mybag.maker.databinding.DialogLoadingBinding

class WaitingDialog(val context: Activity) :
    BaseDialog<DialogLoadingBinding>(context, maxWidth = true, maxHeight = true) {
    override val layoutId: Int = R.layout.dialog_loading
    override val isCancelOnTouchOutside: Boolean = false
    override val isCancelableByBack: Boolean = false

    override fun initView() {
        // Start loading animation for dot

    }

    override fun initAction() {}

    override fun onDismissListener() {}

}