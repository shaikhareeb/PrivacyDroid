package com.example.cs492.firebaseauth.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs492.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavigationDrawerViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {

    fun logoutUser() = viewModelScope.launch {
        repo.signOut()
    }
}