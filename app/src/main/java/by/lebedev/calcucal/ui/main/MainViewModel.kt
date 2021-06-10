package by.lebedev.calcucal.ui.main

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.lebedev.calcucal.ui.main.database.MealDatabase
import by.lebedev.calcucal.ui.main.database.entity.Meal
import by.lebedev.calcucal.ui.main.repository.MealRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {



    private val mealRepository = MealRepository(MealDatabase.getDatabase(application))
    private val ioScope= CoroutineScope(Dispatchers.IO)

    private val _caloriesSum = MutableLiveData<List<Meal>>()
    val caloriesCum: LiveData<List<Meal>> = _caloriesSum


    private val _mealList = MutableLiveData<List<Meal>>()
    val mealList: LiveData<List<Meal>> = _mealList

    fun insert(meal: Meal) {
        ioScope.launch {
            mealRepository.insert(meal)
            _mealList.postValue(mealRepository.loadAllMeal())
        }
    }
    fun loadAllMeal() {
        ioScope.launch {
            _mealList.postValue(mealRepository.loadAllMeal())
        }
    }
    fun addNewMeal(name:String, calories:Int){
        mealRepository.insert(Meal(name, calories))
    }


}