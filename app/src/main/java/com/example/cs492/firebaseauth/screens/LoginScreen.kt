package com.example.cs492.firebaseauth.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cs492.R
import com.example.cs492.Screen
import com.example.cs492.components.GoogleAuthButton
import com.example.cs492.components.OutlinedPasswordInput
import com.example.cs492.components.OutlinedTextInput
import com.example.cs492.components.PrimaryButton
import com.example.cs492.components.SecondaryButton
import com.example.cs492.components.StandardText
import com.example.cs492.firebaseauth.viewmodels.LogInViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LogInViewModel = hiltViewModel()
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var state = viewModel.logInState.collectAsState(initial = null)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        // Show success when they occur:
        LaunchedEffect(state.value?.success) {
            scope.launch {
                state.value?.success?.let {
                    val success = state.value?.success
                    Toast.makeText(context, "$success", Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.Home.route);
                }
            }
        }
        // Show errors when they occur:
        LaunchedEffect(state.value?.error) {
            scope.launch {
                state.value?.error?.let {
                    val error = state.value?.error
                    Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StandardText(value = "Welcome back")
                StandardText(value = "PrivacyDroid - Log in")
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.privacy_tip_24),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Column {
                OutlinedTextInput(
                    value = email,
                    label = { Text("Email") },
                    icon = Icons.Outlined.Email,
                    onInputChange = { email = it}
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedPasswordInput(
                    value = password,
                    label = { Text("Password") },
                    icon = Icons.Outlined.Lock,
                    onInputChange = { password = it }
                )
                Spacer(modifier = Modifier.height(10.dp))
                PrimaryButton(
                    text = "Login",
                    onClick = { scope.launch { viewModel.loginUser(email, password) } },
                    textSize=17.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))
                GoogleAuthButton(
                    text = "Login With Google",
                    onClick = { scope.launch {  Toast.makeText(context, "TODO", Toast.LENGTH_SHORT) }},
                    textSize=17.sp,
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                SecondaryButton(
                    text = "Switch to Signup",
                    onClick = { navController.navigate(Screen.Signup.route)},
                )
            }
        }
    }
}