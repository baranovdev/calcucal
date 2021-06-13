package by.lebedev.calcucal.ui.main.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_table")
data class Meal(
    @ColumnInfo(name = "meal_name")
    val name: MealTypeName,
    @ColumnInfo(name = "meal_calories")
    val calories: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}