package com.example.cs492.features.app_permissions.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs492.Screen
import com.example.cs492.components.PrimaryButton
import com.example.cs492.components.SecondaryButton
import com.example.cs492.components.StandardText
import com.example.cs492.data.app_permission.AppPermissionType

@Composable
fun AppPermissionListScreen(
    navController: NavController,
) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StandardText(value = "App Permissions", fontSize = 20.dp)
                StandardText(value = "There's a lot of permissions you don't know about", fontSize = 14.dp)
                StandardText(value = "Pick one of 4 categories to learn more: ", fontSize = 14.dp)
            }
            Spacer(modifier = Modifier.height(25.dp))
            Column {
                PrimaryButton(
                    text = "Types of Permissions?",
                    onClick = { navController.navigate(Screen.AppPermissionTypesOfPermissions.route)}
                )
                SecondaryButton(
                    text = "Normal Permissions",
                    onClick = { navController.navigate(Screen.AppPermissionOverview.createRoute(AppPermissionType.NORMAL))}
                )
                SecondaryButton(
                    text = "Dangerous Permissions",
                    onClick = { navController.navigate(Screen.AppPermissionOverview.createRoute(AppPermissionType.DANGEROUS))}
                )
                SecondaryButton(
                    text = "Signature Permissions",
                    onClick = { navController.navigate(Screen.AppPermissionOverview.createRoute(AppPermissionType.SIGNATURE))}
                )
            }
        }
    }
}