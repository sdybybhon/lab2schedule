package com.example.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.WeekFragment.Day
import com.example.schedule.databinding.ItemDayBinding
import com.example.schedule.databinding.ItemLessonBinding

class WeekAdapter(private val days: List<Day>) :
    RecyclerView.Adapter<WeekAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemDayBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDayBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val day = days[position]

        holder.binding.dayTitle.text = day.name

        holder.binding.lessonsContainer.removeAllViews()

        holder.binding.emptyState.visibility =
            if (day.lessons.isEmpty()) View.VISIBLE else View.GONE

        day.lessons.forEachIndexed { index, lesson ->
            val lessonBinding = ItemLessonBinding.inflate(
                LayoutInflater.from(holder.itemView.context),
                holder.binding.lessonsContainer,
                false
            )

            lessonBinding.lessonName.text = "${index + 1}. ${lesson.name}"
            lessonBinding.lessonTime.text = "${lesson.time}, ${lesson.room}"
            lessonBinding.lessonTeacher.text = lesson.teacher

            holder.binding.lessonsContainer.addView(lessonBinding.root)
        }
    }

    override fun getItemCount(): Int = days.size
}