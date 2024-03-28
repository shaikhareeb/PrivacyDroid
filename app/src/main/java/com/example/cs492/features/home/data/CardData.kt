package com.example.cs492.features.home.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.QuestionMark
import com.example.cs492.components.ExpandableHeaderCardData
import com.example.cs492.util.ImageType

val HomePageCardData: List<ExpandableHeaderCardData> = listOf(
    ExpandableHeaderCardData(
        headerText = "Why is phone privacy important?",
        icon = ImageType.Vector(Icons.Filled.PrivacyTip),
        iconContentDescription = "privacy tip icon",
        descriptionText = """
            Firstly, smartphones store an immense amount of personal data, from conversations and photos to passwords and personal information. 
            Losing access to this information due to theft or loss of the phone poses significant risks, 
            including identity theft, financial loss, and privacy breaches. 
            
            Public Wi-Fi networks, often used without a second thought, are hotbeds for data interception by malicious actors, 
            making data privacy on phones a critical concern.
            
            While you can't control which WIFI you have access to you do have the ability to learn about different spheres of security to protect yourself
            
            American internet users revealed that 81% of respondents believed they had no control over data collected by private companies, we want to bring this number down.
            To read more about the 
        """.trimIndent(),
        learnMoreLink = "https://www.pewresearch.org/internet/2019/11/15/americans-and-privacy-concerned-confused-and-feeling-lack-of-control-over-their-personal-information/"
    ),
    ExpandableHeaderCardData(
        headerText = "What can this app teach me?",
        icon = ImageType.Vector(Icons.Filled.QuestionMark),
        iconContentDescription = "question mark icon",
        descriptionText = """
            This app will go over many aspects of security and privacy, all related to the android device you're using to read this information.
            The topics it will cover include: 
            
            1) App permissions and the dangers behind them
            2) Navigating Security on your Android Phone
            3) Security Blogs on flaws within Android Apps
            4) Breakdown of app marketplaces 
            
            This is a quick overview but each section of our app goes into in-depth research on each of these topics.
            To view any of these topics use the side navigation panel at the top left of the app
        """.trimIndent(),
    ),
    ExpandableHeaderCardData(
        headerText = "Android security tips for beginners?",
        icon = ImageType.Vector(Icons.Filled.Book),
        iconContentDescription = "book icon",
        descriptionText = """
            There are many resources to learn, but a quick overview on tips to follow:
            
            1. Avoid Installing Apps from Unknown Sources - unless you thoroughly researched the marketplace.
            2. Scrutinize App Permissions - always figure out which permissions each app requires and which ones they simply want
            3. Update Your Android version regularly - SEV (Security vulnerabilities) will always exist, but so will patches 
            4. Use Secure Connections - Avoid public Wi-Fi networks when possible, as they can be insecure
            5. Device Locking Mechanisms: Utilize a strong lock screen password or biometric lock to prevent unauthorized access
            6. Data Encryption: Enable data encryption on your device to protect your personal information 
            7. Manage Notifications: Disable notifications on the lock screen for apps that display sensitive information
            8. Implement Two-Factor Authentication: Use two-factor authentication for Google and other apps that offer it
            
            These tips were sourced from NY Times - to read a full breakdown and learn more click the link below
        """.trimIndent(),
        learnMoreLink = "https://www.nytimes.com/wirecutter/guides/privacy-tips-for-android-phone/"
    ),
    ExpandableHeaderCardData(
        headerText = "How can I support this project?",
        icon = ImageType.Vector(Icons.Filled.MonetizationOn),
        iconContentDescription = "book icon",
        descriptionText = """
            This project is starting out as an altruistic endeavor.
            Please share this app with anyone you believe could benefit from it, especially the elderly.
            If you want to donate, you can buy a coffee for the developers using the link below
            
            But ultimately the best thing you can do is share this content with others that need it :)
        """.trimIndent(),
        learnMoreLink = "https://www.buymeacoffee.com/tldralgos"
    ),
)












