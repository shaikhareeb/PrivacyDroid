package com.example.cs492.features.app_permissions.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.cs492.components.ExpandableCard
import com.example.cs492.components.StandardText
import com.example.cs492.features.home.data.PermissionTypeCardData

@Composable
fun AppPermissionTypesScreen(
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
                item { StandardText(value = "App Permissions - Types", fontSize = 18.sp) }
                item {
                    StandardText(
                        value = """
                        Explore the different types of app permissions on Android, including Install-time, Runtime, and Special permissions. Each has a specific role in how apps interact and access your information. 
                        """.trimIndent(), fontSize = 14.sp)
                }
                item { StandardText(value = "Select one of the 3 to learn more: ", fontSize = 16.sp) }

                PermissionTypeCardData.forEach {
                    item { ExpandableCard(navController = navController, cardData = it) }
                }
        }
    }
}