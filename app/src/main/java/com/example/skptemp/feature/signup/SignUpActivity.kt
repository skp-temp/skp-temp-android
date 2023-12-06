package com.example.skptemp.feature.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.skptemp.R
import com.example.skptemp.common.ui.ViewPagerAdapter
import com.example.skptemp.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    private var _binding: ActivitySignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
    }

    override fun onResume() {
        super.onResume()
        setupViewPager()
    }

    private fun setupViewPager() {
        val fragments = listOf(
            SignUpTermsFragment(),
            SignUpNameFragment()
        )

        val adapter = ViewPagerAdapter(
            fragments,
            supportFragmentManager,
            lifecycle
        )

        with(binding) {
            viewPager.adapter = adapter
            viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            nextButton.setOnClickListener {
                viewPager.currentItem += 1
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private val TAG = SignUpActivity::class.simpleName
    }
}