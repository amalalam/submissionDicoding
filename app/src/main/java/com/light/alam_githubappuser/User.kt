package com.light.alam_githubappuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var name: String? = "",
    var username: String? ="",
    var photo: Int = 0,
    var company: String?="",
    var location: String?="",
    var repository: Int = 0,
    var follower: Int = 0,
    var following: Int = 0
) : Parcelable