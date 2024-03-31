package com.example.cs492.features.app_permissions.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cs492.Screen
import com.example.cs492.components.PrimaryButton
import com.example.cs492.components.SecondaryButton
import com.example.cs492.components.StandardText
import com.example.cs492.data.app_permission.AppPermissionType

@Composable
fun AppPermissionHomeScreen(
    navController: NavController,
) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { StandardText(value = "App Permissions - Home", fontSize = 18.sp) }
            item { StandardText(
                value = """
                    Understanding app permissions is crucial for protecting your privacy and ensuring your device's security. 
                 
                    Many apps request access to various functions or data on your device, such as your camera, contacts, or location. 
                    
                    These permissions can be categorized into different levels based on their potential impact on your privacy and device operation.
                     
                """.trimIndent(), fontSize = 14.sp
            )}
            item { StandardText(value = "Pick one of 4 categories to learn more: ", fontSize = 16.sp) }
            item { Spacer(modifier = Modifier.height(10.dp)) }
            item { PrimaryButton(
                text = "Types of Permissions?",
                onClick = { navController.navigate(Screen.AppPermissionTypesOfPermissions.route) }
            ) }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item { SecondaryButton(
                text = "Normal Permissions",
                onClick = {
                    navController.navigate(
                        Screen.AppPermissionList.createRoute(
                            AppPermissionType.NORMAL
                        )
                    )
                },
            ) }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item { SecondaryButton(
                text = "Dangerous Permissions",
                onClick = {
                    navController.navigate(
                        Screen.AppPermissionList.createRoute(
                            AppPermissionType.DANGEROUS
                        )
                    )
                },
            ) }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item { SecondaryButton(
                text = "Signature Permissions",
                onClick = {
                    navController.navigate(
                        Screen.AppPermissionList.createRoute(
                            AppPermissionType.SIGNATURE
                        )
                    )
                },
            )}
        }
    }
}