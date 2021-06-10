package by.lebedev.calcucal.ui.main.database

import by.lebedev.calcucal.ui.main.database.dao.MealDao
import by.lebedev.calcucal.ui.main.database.entity.Meal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Meal::class], version = 1)
abstract class MealDatabase : RoomDatabase() {

    abstract fun mealDao(): MealDao

    companion object {
        var INSTANCE: MealDatabase? = null

        fun getDatabase(context: Context): MealDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MealDatabase::class.java, "database").build()
                INSTANCE as MealDatabase
            } else INSTANCE as MealDatabase
        }
    }
}