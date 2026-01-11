package com.example.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.schedule.databinding.FragmentRootBinding

class RootFragment : Fragment() {

    private lateinit var binding: FragmentRootBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRootBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, TodayFragment())
            .commit()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.today -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, TodayFragment())
                        .commit()
                    true
                }
                R.id.week -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, WeekFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}