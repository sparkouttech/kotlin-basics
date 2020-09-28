package com.example.kotlin.ui.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User() : Parcelable {
    var id: String = ""
    var name: String = ""
    override fun toString(): String {
        return "User(id='$id', name='$name')"
    }

}