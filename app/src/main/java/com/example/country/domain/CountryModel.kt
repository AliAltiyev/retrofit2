package com.example.country.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CountryModel(


    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String?,


    @ColumnInfo(name = "region")
    @SerializedName("region")
    val region: String?,

    @ColumnInfo(name = "capital")
    @SerializedName("capital")
    val capital: String?,

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    val currency: String?,


    @ColumnInfo(name = "language")
    @SerializedName("language")
    val language: String?,

    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    val imageUrl: String?,


    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}