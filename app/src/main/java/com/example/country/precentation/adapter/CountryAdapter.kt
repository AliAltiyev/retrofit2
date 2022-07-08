package com.example.country.precentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.country.databinding.FeedFragmentRecyclerViewItemBinding
import com.example.country.domain.CountryModel
import com.example.country.util.download

class CountryAdapter(private val countryList: List<CountryModel>) :
    RecyclerView.Adapter<CountryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val view = FeedFragmentRecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)

        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.feedFragmentRecyclerViewItemCountryNameTxt.text = countryList[position].name
        holder.binding.feedFragmentRecyclerViewItemRegionNameTxt.text = countryList[position].region
        holder.binding.imageItem.download(countryList[position].imageUrl,
            CircularProgressDrawable(holder.itemView.context))


    }

    override fun getItemCount() = countryList.size
}