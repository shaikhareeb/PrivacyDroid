package com.example.cs492.repository

import com.example.cs492.domain.model.Response
import com.example.cs492.domain.types.User
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    var user: FirebaseUser?
    fun login(email: String, password: String): Flow<Response<AuthResult>>
    fun signup(name: String, email: String, password: String): Flow<Response<AuthResult>>

    fun sendPasswordResetEmail(email: String): Flow<Response<Boolean>>
    suspend fun getUserInfo(uid: String): Response<User>
    fun signOut()
}