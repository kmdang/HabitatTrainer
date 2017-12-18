package com.example.kdang.habittrainer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.single_card.view.*

class HabitsAdapter(val habits: List<Habit>) : RecyclerView.Adapter<HabitsAdapter.HabitViewHolder>() {

    class HabitViewHolder(val card: View) : RecyclerView.ViewHolder(card)

    // specifies the contents for the shown habit
    override fun onBindViewHolder(holder: HabitViewHolder?, index: Int) {
        if(holder != null) {
            val habit = habits[index]
            holder.card.tv_title.text = habit.title
            holder.card.tv_description.text = habit.description
            holder.card.iv_icon.setImageResource(habit.image)

        }
    }

    // called every time the recycler view has to create a new view object of HabitViewHolder
    // for this function, each HabitViewHolder refers to the layout of one card
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_card, parent, false)

        return HabitViewHolder(view)
    }

    override fun getItemCount() = habits.size

}