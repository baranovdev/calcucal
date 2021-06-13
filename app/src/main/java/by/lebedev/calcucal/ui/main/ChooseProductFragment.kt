package by.lebedev.calcucal.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.lebedev.calcucal.R
import by.lebedev.calcucal.ui.main.database.entity.Meal
import com.google.android.material.textfield.TextInputLayout

class ChooseProductFragment : Fragment() {

    lateinit var viewModel :MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.choose_product_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val textField = view.findViewById<TextInputLayout>(R.id.textField)
        val inputCalories = view.findViewById<TextInputLayout>(R.id.inputCalories)
        val items = viewModel.names
        val adapter = ArrayAdapter(requireContext(), R.layout.item_list, items)
        (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        view.findViewById<Button>(R.id.button_add).setOnClickListener {
            if(!viewModel.names.contains(textField.editText?.text.toString())) textField.error = "Выберите продукт из списка"
            else if(inputCalories.editText?.text.toString().toInt() < 0) inputCalories.error = "Поле должно быть положительным"
            else {
                if(viewModel.caloriesSum.value== null) viewModel.setNewSum(0)
                val index = viewModel.names.indexOf(textField.editText?.text.toString())
                val currentCalories = inputCalories.editText?.text.toString().toInt() * MealList.listOfMeal[index].calories / 100
                val newMeal = Meal(textField.editText?.text.toString(), currentCalories)
                viewModel.insert(newMeal)
                val vmValue =  viewModel.caloriesSum.value?.toInt()
                val newValue = vmValue?.plus(currentCalories)
                viewModel.setNewSum(newValue!!)
                findNavController().navigate(R.id.showMainFragment)
            }

        }

    }

}