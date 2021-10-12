package com.example.dagger_with_retrofit.dagger//package com.example.dagger_with_retrofit
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//
//class AppViewModelProvider(private val repo: Repo) : ViewModelProvider.Factory {
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return when (modelClass) {
//            MainActivityViewModel::javaClass -> MainActivityViewModel() as T
//            else -> throw ClassCastException("View Model not found")
//        }
//    }
//}
