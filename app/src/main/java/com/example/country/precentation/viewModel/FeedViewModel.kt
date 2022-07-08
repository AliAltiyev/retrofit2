package com.example.country.precentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.country.data.service.ApiService
import com.example.country.domain.CountryModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {

    val countryList = MutableLiveData<List<CountryModel>>()
    val error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    private val disposables = CompositeDisposable()
    private val apiService = ApiService()

    fun refreshCountryList() {
        getApi()
    }


    private fun getApi() {

        disposables.add(


            apiService.getData().subscribeOn(
                Schedulers.io()

            ).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CountryModel>>() {
                    override fun onSuccess(t: List<CountryModel>) {
                        countryList.value = t
                        loading.value = false
                        error.value = false
                    }

                    override fun onError(e: Throwable) {

                        error.value = true
                        loading.value = true

                    }


                })


        )


    }


}