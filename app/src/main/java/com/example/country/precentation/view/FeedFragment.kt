package com.example.country.precentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.country.databinding.FragmentFeedBinding
import com.example.country.precentation.adapter.CountryAdapter
import com.example.country.precentation.viewModel.FeedViewModel


class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var adapter: CountryAdapter
    private val viewModel by lazy {
        ViewModelProvider(this)[FeedViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): androidx.swiperefreshlayout.widget.SwipeRefreshLayout {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.refreshCountryList()


        viewModel.countryList.observe(viewLifecycleOwner, Observer { countryList ->
            adapter = CountryAdapter(countryList)
            binding.recyclerview.adapter = adapter


        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            if (error == true) {

                binding.errorTxt.visibility = View.VISIBLE
                binding.recyclerview.visibility = View.GONE
            } else {
                binding.errorTxt.visibility = View.GONE

            }


            viewModel.loading.observe(viewLifecycleOwner) { loading ->
                if (loading == true) {
                    binding.feedProgressbar.visibility = View.VISIBLE
                } else {

                    binding.feedProgressbar.visibility = View.GONE
                }
            }


        })


    }
}