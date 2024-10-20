package com.android_application_architecture.android_architecture_patterns.data.email.data_source.local.database

import androidx.annotation.DrawableRes

/**
 * An object class to define an attachment to email object.
 */
data class EmailAttachment(
    @DrawableRes val resId: Int,
    val contentDesc: String
)