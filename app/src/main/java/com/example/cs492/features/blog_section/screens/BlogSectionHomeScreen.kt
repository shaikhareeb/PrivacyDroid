package com.example.cs492.features.blog_section.screens

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
import com.example.cs492.components.ExpandableCard
import com.example.cs492.components.StandardText
import com.example.cs492.features.home.data.BlogSectionCardData

@Composable
fun BlogSectionHomeScreen(
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
            item { StandardText(value = "Exploring Privacy Pitfalls", fontSize = 18.sp) }
            item {
                StandardText(
                    value = """
                    In today's digital age, where convenience often comes at the cost of privacy, understanding how our favorite apps handle our personal data is more critical than ever. In this section, we delve into the world of app privacy, shining a light on some of the most popular apps and their past transgressions. 

                    From permission violations to controversial data-sharing practices, we uncover the privacy abuses that have made headlines and sparked important conversations about digital ethics. 
                """.trimIndent(), fontSize = 14.sp
                )
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            BlogSectionCardData.forEach{
                item {
                    ExpandableCard(navController = navController, cardData = it)
                }
            }
        }
    }
}
