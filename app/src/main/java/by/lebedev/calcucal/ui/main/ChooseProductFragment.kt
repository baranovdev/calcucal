package by.lebedev.calcucal.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.lebedev.calcucal.R

class ChooseProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.choose_product_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonGarnir = view.findViewById<Button>(R.id.btn_garnir)
        buttonGarnir.setOnClickListener { }
        val buttonMilk = view.findViewById<Button>(R.id.btn_milk_product)
        buttonMilk.setOnClickListener {  }
        val buttonVegetables = view.findViewById<Button>(R.id.btn_vegetable)
        buttonVegetables.setOnClickListener {  }
        val buttonFruit = view.findViewById<Button>(R.id.btn_fruit)
        buttonFruit.setOnClickListener {  }
        val buttonMeat = view.findViewById<Button>(R.id.btn_meat)
        buttonMeat.setOnClickListener {  }
        val buttonFish = view.findViewById<Button>(R.id.btn_fish)
        buttonFish.setOnClickListener {  }
    }

    }



