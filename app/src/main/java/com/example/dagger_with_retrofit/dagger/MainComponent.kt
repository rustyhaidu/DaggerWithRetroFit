package com.example.dagger_with_retrofit.dagger

import com.example.dagger_with_retrofit.mvvm.MainActivity
import com.example.dagger_with_retrofit.mvvm.MainActivityViewModel
import dagger.Component

@Component
interface MainComponent {
    fun inject(activity: MainActivity)
    fun inject(viewModel: MainActivityViewModel)
}