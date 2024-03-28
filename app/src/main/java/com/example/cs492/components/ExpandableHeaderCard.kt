package com.example.cs492.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs492.Screen
import com.example.cs492.util.ImageType


data class ExpandableHeaderCardData(
    val headerText: String,
    val icon: ImageType,
    val iconContentDescription: String,
    val descriptionText: String,
    val page: Screen? = null,
    val learnMoreLink: String? = null
)

@Composable
fun ScrollViewWithTitle(
    listData: List<ExpandableHeaderCardData>,
    navController: NavController,
    scrollViewTitle: String,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = scrollViewTitle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        ExpandableCardList(navController, listData)
    }
}

@Composable
fun ExpandableCardList(
    navController: NavController,
    items: List<ExpandableHeaderCardData>
) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items.size) { index ->
            ExpandableCard(
                navController = navController,
                cardData = items[index]
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun ExpandableCard(
    navController: NavController,
    cardData: ExpandableHeaderCardData,
) {
    val uriHandler = LocalUriHandler.current
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .animateContentSize(), // Animates size changes
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(modifier = Modifier
            .padding(12.dp)
            .clickable { expanded = !expanded }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = cardData.icon.resolveImage(),
                    contentDescription = cardData.iconContentDescription,
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = cardData.headerText,
                    color = Color.White
                )
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = cardData.descriptionText,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))

                cardData.page?.let {
                    Button(
                        onClick = {
                            navController.navigate(cardData.page.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(1.dp, Color.White),
                        contentPadding = PaddingValues()
                    ) {
                        Text("Navigate Over", color = Color.White)
                    }
                }
                cardData.learnMoreLink?.let {
                    Button(
                        onClick = {
                            uriHandler.openUri(cardData.learnMoreLink)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(1.dp, Color.White),
                        contentPadding = PaddingValues()
                    ) {
                        Text("Learn More", color = Color.White)
                    }
                }
            }
        }
    }
}
