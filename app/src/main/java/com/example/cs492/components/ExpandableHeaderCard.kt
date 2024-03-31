package com.example.cs492.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs492.Screen
import com.example.cs492.util.ImageType


data class ScreenButton (val page: Screen, val buttonText: String)
data class LinkButton (val link: String, val buttonText: String)

data class ExpandableHeaderCardData(
    val headerText: String,
    val icon: ImageType,
    val iconContentDescription: String,
    val descriptionText: String,
    val pageData: ScreenButton? = null,
    val linkData: LinkButton? = null
)

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
            .animateContentSize(),
        shape = RoundedCornerShape(8.dp),
        colors = cardColors(containerColor = Color.Black)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { expanded = !expanded }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = cardData.icon.resolveImage(),
                    contentDescription = cardData.iconContentDescription,
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = cardData.headerText,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = cardData.descriptionText,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))

                cardData.pageData?.let {
                    TertiaryButton(
                        onClick = { navController.navigate(it.page.route) },
                        text = it.buttonText
                    )
                }
                cardData.linkData?.let {
                    TertiaryButton(
                        onClick = { uriHandler.openUri(it.link) },
                        text = it.buttonText
                    )
                }
            }
        }
    }
}
