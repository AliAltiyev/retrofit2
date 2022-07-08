package com.example.country.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.country.domain.CountryModel


@Dao
interface Dao {

    @Insert
    fun insertAllCountry(vararg: CountryModel): List<Long>


    @Query("SELECT * FROM CountryModel  WHERE id = :countryID")
    fun getCountry(countryID: Int): CountryModel


    @Query("SELECT * FROM CountryModel")
    fun getAllCountry(): List<CountryModel>

}