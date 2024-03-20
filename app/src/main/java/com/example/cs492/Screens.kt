package com.example.cs492

sealed class Screen(val route: String, var drawerItem: Int = 0) {

    // Auth Screens
    object InitialAuthScreen: Screen("initial-auth-screen")
    object Login: Screen("login")
    object Signup: Screen("signup")
    object ResetPassword: Screen("reset-password")

    // Main App Screens
    object Home: Screen("home", 0)

    object AppPermission: Screen("app_permissions", 1)
    object AndroidSettings: Screen("android_settings", 2)
    object BlogSection: Screen("blog_section", 3)
    object AppMarketplace: Screen("app_marketplaces", 4)
}