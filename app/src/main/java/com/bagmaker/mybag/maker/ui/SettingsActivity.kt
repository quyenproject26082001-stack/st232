package com.bagmaker.mybag.maker.ui

import android.view.LayoutInflater
import com.bagmaker.mybag.maker.R
import com.bagmaker.mybag.maker.core.base.BaseActivity
import com.bagmaker.mybag.maker.core.extensions.gone
import com.bagmaker.mybag.maker.core.extensions.handleBackLeftToRight
import com.bagmaker.mybag.maker.core.extensions.policy
import com.bagmaker.mybag.maker.core.extensions.select
import com.bagmaker.mybag.maker.core.extensions.setImageActionBar
import com.bagmaker.mybag.maker.core.extensions.setTextActionBar
import com.bagmaker.mybag.maker.core.extensions.shareApp
import com.bagmaker.mybag.maker.core.extensions.startIntentRightToLeft
import com.bagmaker.mybag.maker.core.extensions.visible
import com.bagmaker.mybag.maker.core.utils.key.IntentKey
import com.bagmaker.mybag.maker.core.utils.state.RateState
import com.bagmaker.mybag.maker.databinding.ActivitySettingsBinding
import com.bagmaker.mybag.maker.ui.language.LanguageActivity
import com.bagmaker.mybag.maker.core.extensions.tap
import com.bagmaker.mybag.maker.core.helper.MusicHelper
import com.bagmaker.mybag.maker.core.helper.RateHelper
import kotlin.jvm.java

class SettingsActivity : BaseActivity<ActivitySettingsBinding>() {
    override fun setViewBinding(): ActivitySettingsBinding {
        return ActivitySettingsBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        binding.tvMusic.select()
        initRate()
        initMusic()
    }

    private fun initMusic() {
        updateMusicUI(sharePreference.isMusicEnabled())
    }

    private fun updateMusicUI(isEnabled: Boolean) {
        binding.btnMusic.setImageResource(
            if (isEnabled) R.drawable.ic_sw_on else R.drawable.ic_sw_off_ms
        )
    }

    private fun toggleMusic() {
        val isEnabled = !sharePreference.isMusicEnabled()
        sharePreference.setMusicEnabled(isEnabled)
        updateMusicUI(isEnabled)
        if (isEnabled) {
            MusicHelper.play()
        } else {
            MusicHelper.pause()
        }
    }

    override fun viewListener() {
        binding.apply {
            actionBar.btnActionBarLeft.tap { handleBackLeftToRight() }
            layoutMusic.tap { toggleMusic() }
            btnLang.tap { startIntentRightToLeft(LanguageActivity::class.java, IntentKey.INTENT_KEY) }
            btnShareApp.tap(1500) { shareApp() }
            btnRate.tap {
                RateHelper.showRateDialog(this@SettingsActivity, sharePreference){ state ->
                    if (state != RateState.CANCEL){
                        btnRate.gone()
                        showToast(R.string.have_rated)
                    }
                }
            }
            btnPolicy.tap(1500) { policy() }
        }
    }

    override fun initText() {
        binding.actionBar.tvCenter.select()
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            setImageActionBar(btnActionBarLeft, R.drawable.ic_back)
            setTextActionBar(tvCenter, getString(R.string.settings))
        }
    }

    private fun initRate() {
        if (sharePreference.getIsRate(this)) {
            binding.btnRate.gone()
        } else {
            binding.btnRate.visible()
        }
    }
}