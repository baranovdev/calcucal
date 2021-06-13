package by.lebedev.calcucal.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.lebedev.calcucal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

val floatButtonAddProduct = view.findViewById<FloatingActionButton>(R.id.floating_action_button)
        floatButtonAddProduct.setOnClickListener {
            findNavController().navigate(R.id.showChooseProductFragment)
        }

    }

}