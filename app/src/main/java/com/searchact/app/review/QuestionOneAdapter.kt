package com.searchact.app.review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_question_one.view.*

class QuestionOneAdapter(val questions: ArrayList<String>) :
    RecyclerView.Adapter<QuestionOneAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(question: String) {
            view.tvQuestion.text = question
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_question_one, parent, false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(questions[position])
    }
}