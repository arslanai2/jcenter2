package com.translateall.language.free.translator.dictionary.speechtext.learnenglish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ArslanViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArslanViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ArslanViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}