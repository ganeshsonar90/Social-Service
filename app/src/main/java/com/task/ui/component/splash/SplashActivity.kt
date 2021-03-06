package com.task.ui.component.splash

import android.os.Bundle
import android.os.Handler
import com.task.R
import com.task.ui.ViewModelFactory
import com.task.ui.base.BaseActivity
import com.task.ui.component.home_categories.CategoryListActivity
import com.task.utils.Constants
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 */

class SplashActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override val layoutId: Int
        get() = R.layout.splash_layout

    override fun initializeViewModel() {
        splashViewModel = viewModelFactory.create(splashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToMainScreen()
    }

    override fun observeViewModel() {

    }

    private fun navigateToMainScreen() {
        Handler().postDelayed({
            startActivity<CategoryListActivity>()
            finish()
        }, Constants.SPLASH_DELAY.toLong())
    }
}