package com.searchact.app.main.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.searchact.app.R
import com.searchact.app.main.data.Category
import com.searchact.app.models.FeatureListing

class HomeViewModel : ViewModel() {

    private val _categories = MutableLiveData<ArrayList<Category>>().apply {
        value = arrayListOf(
            Category(
                name = "Art & Entertainment",
                image = R.drawable.ic_art_entertainment
            ),
            Category(
                name = "Beauty & Spa",
                image = R.drawable.ic_beauty_spa
            ),
            Category(
                name = "Food & Restaurant",
                image = R.drawable.ic_food_restaurant
            ),
            Category(
                name = "Shopping",
                image = R.drawable.ic_shopping
            ),
            Category(
                name = "Automotive",
                image = R.drawable.ic_automotive
            ),
            Category(
                name = "Doctor",
                image = R.drawable.ic_doctor
            ),
            Category(
                name = "Lawyer",
                image = R.drawable.ic_lawyer
            ),
            Category(
                name = "Real Estate",
                image = R.drawable.ic_real_estate
            )
        )
    }
    val categories: LiveData<ArrayList<Category>> = _categories

    private val _features = MutableLiveData<ArrayList<FeatureListing>>().apply {
        value = arrayListOf(
            FeatureListing(
                image = R.drawable.resturent_half_corner,
                title = "The Little Kitchen",
                date = "March 12,2019",
                location = "in Irish, Near by food place, Steak Hou… ",
                address = "129 Leeson Street Upper Dublin R",
                phoneNumber = "35316718654",
                dateTime = "Today 10:30am - 11:30pm",
                website = "thefarmfood.ie", vote = 10, rate = 4
            )
            ,
            FeatureListing(
                image = R.drawable.resturent_half_corner,
                title = "The Little Kitchen",
                date = "March 12,2019",
                location = "in Irish, Near by food place, Steak Hou… ",
                address = "129 Leeson Street Upper Dublin R",
                phoneNumber = "35316718654",
                dateTime = "Today 10:30am - 11:30pm",
                website = "thefarmfood.ie", vote = 10, rate = 4
            )

            ,
            FeatureListing(
                image = R.drawable.resturent_half_corner,
                title = "The Little Kitchen",
                date = "March 12,2019",
                location = "in Irish, Near by food place, Steak Hou… ",
                address = "129 Leeson Street Upper Dublin R",
                phoneNumber = "35316718654",
                dateTime = "Today 10:30am - 11:30pm",
                website = "thefarmfood.ie", vote = 10, rate = 4

            ),
            FeatureListing(
                image = R.drawable.resturent_half_corner,
                title = "The Little Kitchen",
                date = "March 12,2019",
                location = "in Irish, Near by food place, Steak Hou… ",
                address = "129 Leeson Street Upper Dublin R",
                phoneNumber = "35316718654",
                dateTime = "Today 10:30am - 11:30pm",
                website = "thefarmfood.ie", vote = 10, rate = 4
            )

        )
    }
    val features: LiveData<ArrayList<FeatureListing>> = _features
}