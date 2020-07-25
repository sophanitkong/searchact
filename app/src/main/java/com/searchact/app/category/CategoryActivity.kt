package com.searchact.app.category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.main.data.Category
import com.searchact.app.main.ui.home.CategoryAdapter
import com.searchact.app.main.ui.home.OnCategoryClicked
import com.searchact.app.models.FriendRequest
import com.searchact.app.productcategory.ProductCategoryActivity
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CategoryActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryAdapter
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        adapter = CategoryAdapter(arrayListOf())
        layoutManager = GridLayoutManager(this, 4)

        rcAllCategory.layoutManager = layoutManager
        rcAllCategory.adapter = adapter

        setupToolbar()
        setupAdapter()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.categories)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        adapter.categories.clear()
        val categories = arrayListOf(
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
            ),
            Category(
                name = "Travel & Hotels",
                image = R.drawable.ic_travel_hotels
            ),
            Category(
                name = "Pets",
                image = R.drawable.ic_pets
            ),
            Category(
                name = "Electronics",
                image = R.drawable.ic_electronics
            ),
            Category(
                name = "Financial Services",
                image = R.drawable.ic_bank
            )
        )
        adapter.categories.addAll(categories)
        adapter.notifyDataSetChanged()

        adapter.onCategoryClicked = object : OnCategoryClicked {
            override fun onCategoryClicked(category: Category) {
                val intent = Intent(this@CategoryActivity, ProductCategoryActivity::class.java)
                intent.putExtra("category_name", category.name)
                startActivity(intent)
            }
        }
    }
}
