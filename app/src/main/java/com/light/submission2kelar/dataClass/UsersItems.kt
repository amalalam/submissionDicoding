package com.light.submission2kelar.dataClass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsersItems (
    var name: String? = "",
    var username: String? ="",
    var avatar: String? = "",
    var company: String? = "",
    var repository: String? = "",
    var location: String? = "",
    var follower: String? = "",
    var following: String? = ""
): Parcelable