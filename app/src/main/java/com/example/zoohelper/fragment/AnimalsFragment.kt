package com.example.zoohelper.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zoohelper.R
class AnimalsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Здесь можно разместить макет для фрагмента
        return inflater.inflate(R.layout.fragment_animals, container, false)
    }
}