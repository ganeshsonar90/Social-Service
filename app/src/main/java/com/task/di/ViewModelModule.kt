package com.task.di

import androidx.lifecycle.ViewModel
import com.task.ui.component.home_categories.CategoriesListViewModel
import com.task.ui.component.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CategoriesListViewModel::class)
    abstract fun bindUserViewModel(viewModel: CategoriesListViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel


}
