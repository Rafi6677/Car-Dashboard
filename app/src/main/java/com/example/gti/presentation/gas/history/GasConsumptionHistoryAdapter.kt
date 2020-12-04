package com.example.gti.presentation.gas.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gti.R
import com.example.gti.data.db.model.Gas
import com.example.gti.databinding.ItemFuelConsumptionBinding
import com.example.gti.utils.CalculationUtils
import com.example.gti.utils.StringUtils
import kotlin.collections.ArrayList

class GasConsumptionHistoryAdapter(private val clickListener: (Gas) -> Unit)
    : RecyclerView.Adapter<GasConsumptionViewHolder>() {

    private val gasConsumptionList = ArrayList<Gas>()

    fun setList(gasConsumptionList: List<Gas>?) {
        this.gasConsumptionList.clear()

        if (gasConsumptionList != null) {
            this.gasConsumptionList.addAll(gasConsumptionList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GasConsumptionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemFuelConsumptionBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_fuel_consumption,
            parent,
            false
        )

        return GasConsumptionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gasConsumptionList.size
    }

    override fun onBindViewHolder(holder: GasConsumptionViewHolder, position: Int) {
        holder.bind(gasConsumptionList[position], clickListener)
    }

}

class GasConsumptionViewHolder(val binding: ItemFuelConsumptionBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gas: Gas, clickListener:(Gas)->Unit) {
        binding.fuelConsumedTextView.text = CalculationUtils.calculateFuelConsumptionToString(gas)
        binding.travelDistanceTextView.text = StringUtils.getStringFromDouble(gas.travelDistance)

        if (gas.gasPrice == 0.toDouble()) {
            binding.gasRefuelingPriceTextView.text = "-.-"
            binding.gasPerLiterPriceTextView.text = "-.-"
        } else {
            binding.gasRefuelingPriceTextView.text = CalculationUtils.calculateGasRefuelingPrice(gas)
            binding.gasPerLiterPriceTextView.text = StringUtils.getStringFromDouble(gas.gasPrice)
        }

        binding.refuelingDateTextView.text = StringUtils.formatDateFromTimestampToString(gas.lastRefuelingTimestamp)

        binding.deleteButton.setOnClickListener {
            clickListener(gas)
        }
    }

}