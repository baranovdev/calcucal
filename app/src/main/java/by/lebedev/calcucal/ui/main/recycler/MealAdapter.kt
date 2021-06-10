package by.lebedev.calcucal.ui.main.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.lebedev.calcucal.R
import by.lebedev.calcucal.ui.main.database.entity.Meal

class MealAdapter(private val meals:List<Meal>) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    inner class MealViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun setData(itemView : View, position:Int){

            val meal = meals[position]


            itemView.findViewById<TextView>(R.id.meal_name).text = meal.name
            itemView.findViewById<TextView>(R.id.meal_calories).text = meal.calories.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.setData(holder.itemView, position)
    }

    override fun getItemCount(): Int {
        return meals.size
    }


}