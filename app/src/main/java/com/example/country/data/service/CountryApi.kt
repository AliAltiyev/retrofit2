package com.example.country.data.service

import com.example.country.domain.CountryModel
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {

    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getData(): Single<List<CountryModel>>


}