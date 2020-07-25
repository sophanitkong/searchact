package com.searchact.app.review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import kotlinx.android.synthetic.main.activity_review_business.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ReviewBusinessActivity : AppCompatActivity() {

    private lateinit var questionOneAdapter: QuestionOneAdapter
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_business)

        questionOneAdapter = QuestionOneAdapter(ArrayList())
        layoutManager = GridLayoutManager(this, 2)

        rcQuestionOne.layoutManager = layoutManager

        setupToolbar()
        setupQuestionOneAdapter()
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Review This Business"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupQuestionOneAdapter() {
        questionOneAdapter.questions.clear()
        questionOneAdapter.questions.add("Amazing")
        questionOneAdapter.questions.add("Very Positive")
        questionOneAdapter.questions.add("Top Quality")
        questionOneAdapter.questions.add("Cheer!")
        questionOneAdapter.questions.add("You Rock!")
        questionOneAdapter.questions.add("Hi 5!")
        questionOneAdapter.questions.add("Unique")
        questionOneAdapter.questions.add("Over Priced")
        questionOneAdapter.questions.add("Unrealiable")
        questionOneAdapter.questions.add("Best Business")
        questionOneAdapter.questions.add("Consistent")
        questionOneAdapter.questions.add("Thanks-You!")
        questionOneAdapter.questions.add("Many Thanks!")
        questionOneAdapter.questions.add("Well Done!")
        questionOneAdapter.questions.add("Usefull")
        questionOneAdapter.questions.add("Value for money")
        questionOneAdapter.questions.add("Poor Quality")
        questionOneAdapter.questions.add("Usefull")
        questionOneAdapter.notifyDataSetChanged()

        rcQuestionOne.adapter = questionOneAdapter
    }

}
