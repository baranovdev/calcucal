package by.lebedev.calcucal.ui.main

import by.lebedev.calcucal.ui.main.database.entity.Meal
import by.lebedev.calcucal.ui.main.database.entity.MealTypeName

object MealList {

    val listOfMeal:List<Meal> = listOf(

        Meal(MealTypeName.BEEF.type, 191),
        Meal(MealTypeName.PORK.type, 318),
        Meal(MealTypeName.VEAL.type,91),
        Meal(MealTypeName.MILK.type,52),
        Meal(MealTypeName.KEFIR.type,40),
        Meal(MealTypeName.YOGURT.type,60),
        Meal(MealTypeName.PERCH.type,123),
        Meal(MealTypeName.SAURY.type,257),
        Meal(MealTypeName.SALMON.type,222),
        Meal(MealTypeName.HALIBUT.type,106),
        Meal(MealTypeName.HARD_CHEESE.type,352),
        Meal(MealTypeName.SOFT_CHEESE.type,27),
        Meal(MealTypeName.COTTAGE_CHEESE.type,120),
        Meal(MealTypeName.MANDARIN.type,133),
        Meal(MealTypeName.BUCKWHEAT.type,120),
        Meal(MealTypeName.POTATO_PUREE.type,74),
        Meal(MealTypeName.POTATO_FRIED.type,147),
        Meal(MealTypeName.RISE.type,143),
        Meal(MealTypeName.PEARL_BARLEY.type,111),
        Meal(MealTypeName.MILLET.type,95),
        Meal(MealTypeName.CUCUMBER.type,14),
        Meal(MealTypeName.BANANA.type,94),
        Meal(MealTypeName.BOILED_EGG.type,152),
        Meal(MealTypeName.TOMATO.type,20),
        Meal(MealTypeName.APPLE.type,57),
        Meal(MealTypeName.BLACK_BREAD.type,201),
        Meal(MealTypeName.WHITE_BREAD.type,253),
        Meal(MealTypeName.ORANGE.type,50),
        Meal(MealTypeName.STRAWBERRY.type,35),
        Meal(MealTypeName.PANCAKE.type,234),
        Meal(MealTypeName.BORSCHT.type,50)
    )

}