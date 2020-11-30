package com.example.gti.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.gti.R
import com.example.gti.databinding.FragmentHomeBinding
import com.example.gti.presentation.di.Injector
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: HomeViewModelFactory

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as Injector).createHomeSubComponent()
            .inject(this)

        homeViewModel = ViewModelProvider(this, factory)
            .get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        binding.viewModel = homeViewModel
        binding.lifecycleOwner = this

        prepareView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

    override fun onStart() {
        super.onStart()
        refreshData()
    }

    private fun prepareView() {
        Glide.with(this)
            .load(R.drawable.background4)
            .centerCrop()
            .into(binding.mainBackgroundImageView)

        Glide.with(this)
            .load(R.drawable.icon_fuel_white)
            .into(binding.gasImageView)

        Glide.with(this)
            .load(R.drawable.icon_oil_white)
            .into(binding.oilImageView)

        Glide.with(this)
            .load(R.drawable.icon_document_white)
            .into(binding.documentsImageView)
    }

    private fun initButtons() {
        binding.gasCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_gasFeaturesFragment)
        }
    }

    private fun refreshData() {
        val gasFeaturesResponse = homeViewModel.getLatestGasData()

        gasFeaturesResponse.removeObservers(this)

        gasFeaturesResponse.observe(this, Observer {
            if (it == null) {
                homeViewModel.gasLatestFuelConsumption.value = "-.-  l/100km"
            } else {
                homeViewModel.gasLatestFuelConsumption.value = it.litersConsumed.toString() + " " + R.string.average_fuel_consumption_value
            }
        })
    }

}