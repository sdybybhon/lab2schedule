package com.example.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.databinding.FragmentWeekBinding

class WeekFragment : Fragment() {

    private lateinit var binding: FragmentWeekBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeekBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weekShedule = listOf(
            Day("Понедельник", listOf(
                Lesson("Матан((", "08:00-9:30", "ауд. А12", "Какой-то преподаватель"),
                Lesson("УЖЦПО", "9:40-11:10", "ауд. 326", "Какой-то преподаватель"),
                Lesson("бимбимб", "ибмбимбим", "бимбимбим", "ибмибмбимбим")
            )),
            Day("Вторник", listOf(
                Lesson("ТПП", "11:20-12:50", "ауд. 132а", "Какой-то преподаватель"),
                Lesson("Базы данных", "13:15-14:45", "ауд. 326", "Какой-то преподаватель.")
            )),
            Day("Среда", listOf(
                Lesson("Обед =)", "00:00-23:59", "ауд. дома", "Повар")
            )),
            Day("Четверг", emptyList()),
            Day("Пятница", listOf(
                Lesson("Физ-ра", "11:20-12:50", "Второй корпус вроде", "Какой-то преподаватель"),
                Lesson("Тестирование", "13:15-14:45", "ауд. 132а", "Какой-то преподаватель")
            )),
            Day("Суббота", emptyList()),
            Day("Воскресенье", emptyList())
        )

        binding.weekRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.weekRecyclerView.adapter = WeekAdapter(weekShedule)
    }


    data class Lesson(
        val name: String,
        val time: String,
        val room: String,
        val teacher: String
    )

    data class Day(
        val name: String,
        val lessons: List<Lesson>
    )
}