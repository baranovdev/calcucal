package by.lebedev.calcucal.ui.main

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.lebedev.calcucal.ui.main.database.MealDatabase
import by.lebedev.calcucal.ui.main.database.MealDatabase_Impl
import by.lebedev.calcucal.ui.main.database.entity.Meal
import by.lebedev.calcucal.ui.main.database.entity.MealTypeName
import by.lebedev.calcucal.ui.main.repository.MealRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    val names = enumValues<MealTypeName>().joinToString { it.type }.split(", ")

    private val mealRepository = MealRepository(MealDatabase.getDatabase(application))
    private val ioScope= CoroutineScope(Dispatchers.IO)

    private val _caloriesSum = MutableLiveData<Int>()
    val caloriesSum: LiveData<Int> = _caloriesSum

    private val _mealList = MutableLiveData<List<Meal>>()
    val mealList: LiveData<List<Meal>> = _mealList

    fun setNewSum( sum : Int){
        _caloriesSum.value = sum
    }

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
    fun addNewMeal(name:MealTypeName, calories:Int){
        mealRepository.insert(Meal(name.type, calories))
    }


}