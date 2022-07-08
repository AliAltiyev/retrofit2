package com.example.country.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.country.R

fun ImageView.download(url: String?, circularProgressDrawable: CircularProgressDrawable) {

    val options = RequestOptions()
        .placeholder(circularProgressDrawable)
        .error(R.mipmap.ic_launcher_round)


    Glide
        .with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)




    fun progressDrawable(context: Context): CircularProgressDrawable {

        return CircularProgressDrawable(context).apply {
            strokeWidth = 8f
            centerRadius = 40f
            start()
        }
    }

}