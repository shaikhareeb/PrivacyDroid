package com.example.cs492.features.app_marketplaces.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cs492.components.LinkButton
import com.example.cs492.components.PrimaryButton
import com.example.cs492.components.TertiaryButton

@Composable
fun AppMarketplaceHomeScreen() {
    val uriHandler = LocalUriHandler.current
    return Surface {
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            item {
                Text(
                    text = "3rd Party App Marketplaces",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item {
                Text(text = "The EU's Digital Markets Act is a new piece of legislation designed to distribute the market power of major tech companies and ensure fair competition in the digital sector. It specifically targets \"gatekeepers,\" which are large online platforms that serve as critical entry points for business users to reach their customers, such as the Apple App Store and Google Play Store.",
                    modifier = Modifier.paddingFromBaseline(top = 30.dp))
            }
            item {
                Text(text = "As a result we will see new app marketplaces arise and gain popularity. With new app marketplaces it is critical that we examine the policy's and regulations they have set in place to protect user's privacy and security.",
                    modifier = Modifier.paddingFromBaseline(top = 30.dp))

            }
            item {
                Text(
                    text = "F-droid",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.paddingFromBaseline(top = 40.dp)
                )
            }
            item {
                Text(text = "   Although F-droid is a use at your own risk platform, F-droid main goal is providing users with privacy-focused and free software options.")
            }
            item {
                Text(text = "   F-droid doesn't allow you to install other applications from the repository that track you, unless you first enable ‘Tracking’ in the AntiFeatures section of preferences.")
            }
            item {
                Text(text = "    All apps on F-Droid are open source. This allows the community and security experts to inspect the code for malicious behaviors, vulnerabilities, or privacy issues.")
            }
            item {
                Button(
                    onClick = {uriHandler.openUri("https://f-droid.org/en/about/")},
                    modifier = Modifier
                        .paddingFromBaseline(top = 30.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    border = BorderStroke(1.dp, Color.White),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("Learn more about F-droid", color = Color.White)
                }
            }

            item {
                Text(
                    text = "APKMirror",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.paddingFromBaseline(top = 40.dp)
                )
            }
            item {
                Text(text = "   APKMirror attempts to ensure that the APKs available on their site are the same as those available on the Google Play Store, without any modification or tampering. They verify the signatures of the APKs to ensure they match the official developers' signatures and have not been tampered with. This process helps in maintaining the integrity of the APK files, making them relatively safe to download compared to other third-party sources.")
            }
            item {
                Text(text = "   Sideloading bypasses the security checks and balances Google has in place for apps distributed through its store. While APKMirror tries to mitigate these risks through its verification processes, the act of sideloading inherently carries a higher risk compared to downloading apps directly from the Play Store.")
            }
            item {
                Button(
                    onClick = {uriHandler.openUri("https://www.apkmirror.com/faq/")},
                    modifier = Modifier
                        .paddingFromBaseline(top = 30.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    border = BorderStroke(1.dp, Color.White),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("Learn more about APKMirror", color = Color.White)
                }
            }

            item {
                Text(
                    text = "Amazon Appstore",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.paddingFromBaseline(top = 40.dp)
                )
            }
            item {
                Text(text = "   Amazon conducts a review process for apps submitted to its Appstore, aiming to check for malicious software and ensure apps comply with their content guidelines. This process includes automated scanning and potentially manual review to identify and mitigate security risks. While no vetting process can be 100% effective in catching all potential threats, Amazon does take measures in reducing the risk of security treats.")
            }
            item {
                Button(
                    onClick = {uriHandler.openUri("https://developer.amazon.com/docs/policy-center/privacy-security.html")},
                    modifier = Modifier
                        .paddingFromBaseline(top = 30.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    border = BorderStroke(1.dp, Color.White),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("Learn more about Amazon Appstore", color = Color.White)
                }
            }
        }
    }
}
