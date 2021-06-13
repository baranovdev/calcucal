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
        val items = viewModel.names
        val adapter = ArrayAdapter(requireContext(), R.layout.item_list, items)
        (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)


    }

}