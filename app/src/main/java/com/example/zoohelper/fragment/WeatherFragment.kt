package com.example.zoohelper.fragment

import VpAdapter
import android.Manifest
import android.app.Instrumentation.ActivityResult
import android.content.pm.LauncherActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.example.zoohelper.R
import com.example.zoohelper.databinding.FragmentListBinding
import com.google.android.material.tabs.TabLayoutMediator

class WeatherFragment : Fragment() {

    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentListBinding


    private val fList = listOf(

        ListFragment.newInstance()
    )
    private val tList = listOf(
        "Hours",
        "Days"
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermisson()
    }
    private fun checkPermisson() {
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun permissionListener() {
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()) {
            Toast.makeText(activity,"Permission is $it",Toast.LENGTH_LONG).show()
        }
    }

}


