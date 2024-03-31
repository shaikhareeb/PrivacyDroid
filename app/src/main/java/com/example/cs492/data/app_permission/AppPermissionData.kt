package com.example.cs492.data.app_permission

class AppPermissionData {
}

enum class AppPermissionType(private val role: String) {
    NORMAL("Normal"),
    DANGEROUS("Dangerous"),
    SIGNATURE("Signature");
    override fun toString(): String {
        return role
    }
}

enum class Permission(private val permissionName: String, private val type: AppPermissionType) {

    // Normal Permissions
    INTERNET("android.permission.INTERNET", AppPermissionType.NORMAL),
    ACCESS_NETWORK_STATE("android.permission.ACCESS_NETWORK_STATE", AppPermissionType.NORMAL),
    ACCESS_WIFI_STATE("android.permission.ACCESS_WIFI_STATE", AppPermissionType.NORMAL),
    SET_ALARM("android.permission.SET_ALARM", AppPermissionType.NORMAL),
    WAKE_LOCK("android.permission.WAKE_LOCK", AppPermissionType.NORMAL),
    RECEIVE_BOOT_COMPLETED("android.permission.RECEIVE_BOOT_COMPLETED", AppPermissionType.NORMAL),
    BLUETOOTH("android.permission.BLUETOOTH", AppPermissionType.NORMAL),
    FOREGROUND_SERVICE("android.permission.FOREGROUND_SERVICE", AppPermissionType.NORMAL),

    // Special Permissions
    CAMERA("android.permission.CAMERA", AppPermissionType.DANGEROUS),
    ACCESS_FINE_LOCATION("android.permission.ACCESS_FINE_LOCATION", AppPermissionType.DANGEROUS),
    READ_EXTERNAL_STORAGE("android.permission.READ_EXTERNAL_STORAGE", AppPermissionType.DANGEROUS),
    WRITE_EXTERNAL_STORAGE("android.permission.WRITE_EXTERNAL_STORAGE", AppPermissionType.DANGEROUS),
    RECORD_AUDIO("android.permission.RECORD_AUDIO", AppPermissionType.DANGEROUS),
    READ_CONTACTS("android.permission.READ_CONTACTS", AppPermissionType.DANGEROUS),
    SEND_SMS("android.permission.SEND_SMS", AppPermissionType.DANGEROUS),
    RECEIVE_SMS("android.permission.RECEIVE_SMS", AppPermissionType.DANGEROUS),
    CALL_PHONE("android.permission.CALL_PHONE", AppPermissionType.DANGEROUS),
    READ_CALENDAR("android.permission.READ_CALENDAR", AppPermissionType.DANGEROUS),

    // Special Permissions
    SYSTEM_ALERT_WINDOW("android.permission.SYSTEM_ALERT_WINDOW", AppPermissionType.SIGNATURE),
    WRITE_SETTINGS("android.permission.WRITE_SETTINGS", AppPermissionType.SIGNATURE),
    PACKAGE_USAGE_STATS("android.permission.PACKAGE_USAGE_STATS", AppPermissionType.SIGNATURE),
    READ_VOICEMAIL("android.permission.READ_VOICEMAIL", AppPermissionType.SIGNATURE);

    // System Permissions

    override fun toString(): String {
        return "$permissionName (${type})"
    }
}
