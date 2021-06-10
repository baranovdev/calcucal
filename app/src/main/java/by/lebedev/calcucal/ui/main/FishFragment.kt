package by.lebedev.calcucal.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import by.lebedev.calcucal.R

class FishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fish_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonFish1 = view.findViewById<Button>(R.id.btn_fish1)
        buttonFish1.setOnClickListener {  }
        val buttonFish2 = view.findViewById<Button>(R.id.btn_fish2)
        buttonFish2.setOnClickListener {  }
        val buttonFish3 = view.findViewById<Button>(R.id.btn_fish3)
        buttonFish3.setOnClickListener {  }
        val buttonFish4 = view.findViewById<Button>(R.id.btn_fish4)
        buttonFish4.setOnClickListener {  }


    }
}