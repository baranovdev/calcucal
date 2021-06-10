package by.lebedev.calcucal.ui.main.database.dao

import androidx.room.*
import by.lebedev.calcucal.ui.main.database.entity.Meal

@Dao
interface MealDao {

    @Insert
    suspend fun insert(meal: Meal)

    @Delete
    suspend fun delete(meal: Meal)

    @Update
    suspend fun update(meal: Meal)

    @Query("SELECT * FROM meal_table")
    suspend fun getAll():List<Meal>

}