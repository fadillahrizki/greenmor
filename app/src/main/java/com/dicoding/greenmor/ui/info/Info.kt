package com.dicoding.greenmor.ui.info

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val name: String,
    val photo: Int
) : Parcelable
