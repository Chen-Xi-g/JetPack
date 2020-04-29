package com.minlukj.databinding.entity


import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class CarEntity(
    val brand : String,
    val engine: String,
    val isLimit: Boolean,
    var price: Long,
    val wheel: String
) : Parcelable
