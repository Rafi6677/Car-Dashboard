package com.example.gti.presentation.gasfeatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gti.R
import com.example.gti.databinding.FragmentGasFeaturesBinding
import com.example.gti.data.db.GtiDatabase
import com.example.gti.utils.KeyboardUtils

class GasFeaturesFragment : Fragment() {

    private lateinit var binding: FragmentGasFeaturesBinding
    private lateinit var gasFeaturesViewModel: GasFeaturesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_gas_features,
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
        KeyboardUtils.initKeyboardButtonsValues(binding.leftKeyboard)
        KeyboardUtils.initKeyboardButtonsValues(binding.middleKeyboard)
        KeyboardUtils.initKeyboardButtonsValues(binding.rightKeyboard)
    }

    private fun initButtons() {
        KeyboardUtils.onMileageKeyboardButtonClicked(binding, binding.leftKeyboard)
        KeyboardUtils.onFuelKeyboardButtonClicked(binding, binding.middleKeyboard)
        KeyboardUtils.onPriceKeyboardButtonClicked(binding, binding.rightKeyboard)

        binding.backButtonImageView.setOnClickListener {
            requireActivity().onBackPressed()
        }

        /*binding.saveButtonImageView.setOnClickListener {
            gasFeaturesViewModel.saveGasFeature(requireActivity(), binding)
        }*/
    }

}