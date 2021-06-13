package by.lebedev.calcucal.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.lebedev.calcucal.R
import by.lebedev.calcucal.ui.main.recycler.MealAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment() {

    lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

val floatButtonAddProduct = view.findViewById<FloatingActionButton>(R.id.floating_action_button)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        recycler.layoutManager = LinearLayoutManager(requireContext())

        var mealAdapter = MealAdapter(viewModel.mealList.value.orEmpty())

        recycler.adapter = mealAdapter

        viewModel.mealList.observe(requireActivity()){
            mealAdapter= MealAdapter(viewModel.mealList.value.orEmpty())
            recycler.adapter = mealAdapter
        }

        viewModel.caloriesSum.observe(requireActivity()){
            view.findViewById<TextView>(R.id.main_calories_sum).text = viewModel.caloriesSum.value.toString().plus(" кКал")
        }

        floatButtonAddProduct.setOnClickListener {
            findNavController().navigate(R.id.showChooseProductFragment)
        }

    }

}