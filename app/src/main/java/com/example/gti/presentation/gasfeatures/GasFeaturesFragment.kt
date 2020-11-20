package com.example.gti.presentation.gasfeatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.gti.R
import com.example.gti.databinding.FragmentGasFeaturesBinding

class GasFeaturesFragment : Fragment() {

    private lateinit var binding: FragmentGasFeaturesBinding

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

        return binding.root
    }

}