package com.example.gti.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.gti.R
import com.example.gti.databinding.FragmentHomeBinding
import com.example.gti.db.GtiDatabase
import com.example.gti.db.repository.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = initViewModelFactory()
        homeViewModel = ViewModelProvider(this, factory)
            .get(HomeFragmentViewModel::class.java)
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

    private fun initViewModelFactory(): HomeFragmentViewModelFactory {
        val database = GtiDatabase.getInstance(requireActivity().application)

        val carInsuranceDAO = database.carInsuranceDAO
        val carInsuranceRepository = CarInsuranceRepository(carInsuranceDAO)

        val carReviewDAO = database.carReviewDAO
        val carReviewRepository = CarReviewRepository(carReviewDAO)

        val gasDAO = database.gasDAO
        val gasRepository = GasRepository(gasDAO)

        val oilChangeDAO = database.oilChangeDAO
        val oilChangeRepository = OilChangeRepository(oilChangeDAO)

        val oilCheckDAO = database.oilCheckDAO
        val oilCheckRepository = OilCheckRepository(oilCheckDAO)

        return HomeFragmentViewModelFactory(
            carInsuranceRepository,
            carReviewRepository,
            gasRepository,
            oilChangeRepository,
            oilCheckRepository
        )
    }

    private fun initButtons() {
        binding.gasCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_gasFeaturesFragment)
        }
    }

}