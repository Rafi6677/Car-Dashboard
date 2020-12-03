package com.example.gti.presentation.gas.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gti.R
import com.example.gti.databinding.FragmentGasConsumptionHistoryBinding
import com.example.gti.presentation.di.Injector
import javax.inject.Inject

class GasConsumptionHistoryFragment : Fragment() {

    @Inject
    lateinit var factory: GasConsumptionHistoryViewModelFactory

    private lateinit var binding: FragmentGasConsumptionHistoryBinding
    private lateinit var gasConsumptionHistoryViewModel: GasConsumptionHistoryViewModel
    private lateinit var adapter: GasConsumptionHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as Injector).createGasHistorySubcomponent()
            .inject(this)

        gasConsumptionHistoryViewModel = ViewModelProvider(this, factory)
            .get(GasConsumptionHistoryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_gas_consumption_history,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.gasHistoryRecyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = GasConsumptionHistoryAdapter()
        binding.gasHistoryRecyclerView.adapter = adapter

        displayGasData()
    }

    private fun displayGasData() {
        binding.noFuelConsumptionDataFoundTextView.visibility = View.GONE
        binding.gasHistoryProgressBar.visibility = View.VISIBLE

        val response = gasConsumptionHistoryViewModel.getGasAllData()

        response.observe(viewLifecycleOwner, Observer {
            if (it!!.isNotEmpty()) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()

                binding.gasHistoryProgressBar.visibility = View.GONE
            } else {
                binding.gasHistoryProgressBar.visibility = View.GONE
                binding.noFuelConsumptionDataFoundTextView.visibility = View.VISIBLE
            }
        })
    }

}