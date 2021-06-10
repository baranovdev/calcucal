package by.lebedev.calcucal.ui.main.repository

import androidx.room.Query
import by.lebedev.calcucal.ui.main.database.MealDatabase
import by.lebedev.calcucal.ui.main.database.dao.MealDao
import by.lebedev.calcucal.ui.main.database.entity.Meal
import kotlinx.coroutines.*

class MealRepository(
    private val database: MealDatabase
) {

    private val dao = database.mealDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(meal: Meal) {
        ioScope.launch {
            dao.insert(meal)
        }
    }

    suspend fun loadAllPerson(): List<Meal> {
        return ioScope.async { dao.getAll() }.await()
    }
}