package com.example.cs492.features.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cs492.R
import com.example.cs492.components.ExpandableCard
import com.example.cs492.components.StandardText
import com.example.cs492.features.home.data.HomePageCardData

@Composable
fun HomeScreen(
        navController: NavController
) {

    return Surface {
        LazyColumn (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.privacy_tip_24),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "Privacy Helper",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            item {
                StandardText(
                    value = "Take Control, Not Chances: Safeguard Your Privacy in a Click-Driven World",
                    fontSize = 16.sp
                )
            }
            HomePageCardData.forEach{
                item {
                    ExpandableCard(navController = navController, cardData = it)
                }
            }
        }
    }
}