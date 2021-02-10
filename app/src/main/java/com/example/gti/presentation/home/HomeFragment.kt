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
import com.example.gti.utils.CalculationUtils
import com.example.gti.utils.StringUtils
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: HomeViewModelFactory

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as Injector).createHomeSubcomponent()
            .inject(this)

        homeViewModel = ViewModelProvider(this, factory)
            .get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
            .load(R.drawable.icon_fuel_white)
            .into(binding.gasImageView)

        Glide.with(this)
            .load(R.drawable.icon_exploitation_white)
            .into(binding.exploitationImageView)

        Glide.with(this)
            .load(R.drawable.icon_document_white)
            .into(binding.documentsImageView)

        Glide.with(this)
            .load(R.drawable.icon_settings_white)
            .into(binding.settingsImageView)
    }

    private fun initButtons() {
        binding.gasCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_gasFeaturesFragment)
        }

        binding.exploitationCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_exploitationFragment)
        }
    }

    private fun refreshData() {
        refreshGasConsumptionData()
       // refreshExploitationData()
    }

    private fun refreshGasConsumptionData() {
        //binding.gasProgressBar.visibility = View.VISIBLE

        val gasConsumptionResponse = homeViewModel.getLatestGasData()

        gasConsumptionResponse.observe(this, Observer {
            if (it == null) {
                homeViewModel.gasLatestFuelConsumption.value = "-.-  l/100km"
                //binding.gasProgressBar.visibility = View.GONE
            } else {
                homeViewModel.gasLatestFuelConsumption.value = CalculationUtils.calculateFuelConsumptionToString(it) + " " +
                        resources.getString(R.string.average_fuel_consumption_value)

                //binding.gasProgressBar.visibility = View.GONE
            }
        })
    }

    private fun refreshExploitationData() {
        //binding.exploitationProgressBar.visibility = View.VISIBLE
        var lastOilChangeDataLoaded = false
        var lastOilLevelCheckDataLoaded = false

        val oilChangeResponse = homeViewModel.getLatestOilChange()

        oilChangeResponse.observe(this, Observer {
            if (it == null) {
                homeViewModel.latestOilChangeDate.value = "Brak danych"
                lastOilChangeDataLoaded = true
            } else {
                homeViewModel.latestOilChangeDate.value = StringUtils.formatDateFromTimestampToString(it.lastOilChangeTimestamp)
                lastOilChangeDataLoaded = true
            }
        })

        val oilLevelCheckResponse = homeViewModel.getLatestOilLevel()

        oilLevelCheckResponse.observe(this, Observer {
            if (it == null) {
                homeViewModel.latestOilLevel.value = "Brak danych"
                lastOilLevelCheckDataLoaded = true
            } else {
                homeViewModel.latestOilLevel.value = it.oilPercentageLevel.toString() + "%"
                lastOilLevelCheckDataLoaded = true
            }
        })

        if (lastOilChangeDataLoaded && lastOilLevelCheckDataLoaded) {
            //binding.exploitationProgressBar.visibility = View.GONE
        }
    }

}