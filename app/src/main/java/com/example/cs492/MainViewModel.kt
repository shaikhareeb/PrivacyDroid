package com.example.cs492

import androidx.lifecycle.ViewModel
import com.example.cs492.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
    fun getLoggedInStatus(): Boolean { return repository.user != null }

    fun getCurrentUserName(): String? { return repository.user?.displayName }

}