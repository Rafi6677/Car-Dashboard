package com.example.gti.presentation.gas.add

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.gti.R
import com.example.gti.data.db.model.Gas
import com.example.gti.databinding.FragmentAddFuelConsumptionBinding
import com.example.gti.presentation.di.Injector
import com.example.gti.utils.KeyboardUtils
import javax.inject.Inject

class AddFuelConsumptionFragment : Fragment() {

    @Inject
    lateinit var factory: GasFeaturesViewModelFactory

    private lateinit var binding: FragmentAddFuelConsumptionBinding
    private lateinit var gasFeaturesViewModel: GasFeaturesViewModel
    private lateinit var gasConsumption: Gas

    private var currentDataOptionSelected: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as Injector).createGasSubcomponent()
            .inject(this)

        gasFeaturesViewModel = ViewModelProvider(this, factory)
            .get(GasFeaturesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_fuel_consumption,
            container,
            false
        )

        prepareView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

    private fun prepareView() {
        setCurrentDataOption(currentDataOptionSelected)
        KeyboardUtils.initHorizontalKeyboardButtonsValues(binding.keyboard)
    }

    private fun initButtons() {
        binding.backButtonImageView.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.historyButtonImageView.setOnClickListener {
            it.findNavController().navigate(R.id.action_addFuelConsumptionFragment_to_gasConsumptionHistoryFragment)
        }

        binding.saveButtonImageView.setOnClickListener {
            if (gasFeaturesViewModel.saveGasFeature(requireActivity(), binding)) {
                requireActivity().onBackPressed()
            }
        }

        binding.distanceImageView.setOnClickListener {
            setCurrentDataOption(0)
        }

        binding.fuelImageView.setOnClickListener {
            setCurrentDataOption(1)
        }

        binding.priceImageView.setOnClickListener {
            setCurrentDataOption(2)
        }
    }

    private fun setCurrentDataOption(optionIndex: Int) {
        currentDataOptionSelected = optionIndex

        when (currentDataOptionSelected) {
            0 -> {
                binding.distanceTitleTextView.typeface = Typeface.DEFAULT_BOLD
                binding.fuelTitleTextView.typeface = Typeface.DEFAULT
                binding.priceTitleTextView.typeface = Typeface.DEFAULT

                binding.distanceImageView.setBackgroundResource(R.drawable.radio_button_top_checked)
                binding.fuelImageView.setBackgroundResource(R.drawable.radio_button_middle_unchecked)
                binding.priceImageView.setBackgroundResource(R.drawable.radio_button_bottom_unchecked)

                KeyboardUtils.onHorizontalMileageKeyboardButtonClicked(binding.distanceValueTextView, binding.keyboard)
            }
            1 -> {
                binding.distanceTitleTextView.typeface = Typeface.DEFAULT
                binding.fuelTitleTextView.typeface = Typeface.DEFAULT_BOLD
                binding.priceTitleTextView.typeface = Typeface.DEFAULT

                binding.distanceImageView.setBackgroundResource(R.drawable.radio_button_top_unchecked)
                binding.fuelImageView.setBackgroundResource(R.drawable.radio_button_middle_checked)
                binding.priceImageView.setBackgroundResource(R.drawable.radio_button_bottom_unchecked)

                KeyboardUtils.onHorizontalFuelKeyboardButtonClicked(binding.fuelValueTextView, binding.keyboard)
            }
            2 -> {
                binding.distanceTitleTextView.typeface = Typeface.DEFAULT
                binding.fuelTitleTextView.typeface = Typeface.DEFAULT
                binding.priceTitleTextView.typeface = Typeface.DEFAULT_BOLD

                binding.distanceImageView.setBackgroundResource(R.drawable.radio_button_top_unchecked)
                binding.fuelImageView.setBackgroundResource(R.drawable.radio_button_middle_unchecked)
                binding.priceImageView.setBackgroundResource(R.drawable.radio_button_bottom_checked)

                KeyboardUtils.onHorizontalPriceKeyboardButtonClicked(binding.priceValueTextView, binding.keyboard)
            }
        }
    }

}