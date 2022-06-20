package com.example.intelligentcctv101.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intelligentcctv101.R
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_main.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment(){
    lateinit var navController: NavController
    val cameraList : ArrayList<Camera> = ArrayList()
    lateinit var recyclerView1 : RecyclerView

    var adapter : CameraAdapter ?= null

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rooteView = inflater.inflate(R.layout.fragment_list,container,false)
        cameraList.add(Camera(R.drawable.cctv_neon2,"거실용",8080,"255.255.255.0"))
        cameraList.add(Camera(R.drawable.cctv_neon2,"부엌용",8080,"255.255.255.0"))
        cameraList.add(Camera(R.drawable.cctv_neon2,"안방용",8080,"255.255.255.0"))
        cameraList.add(Camera(R.drawable.cctv_neon2,"큰방용",8080,"255.255.255.0"))
        cameraList.add(Camera(R.drawable.cctv_neon2,"현관용",8080,"255.255.255.0"))
        recyclerView1 = rooteView.findViewById(R.id.camera_list!!) as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.adapter = CameraAdapter(requireContext(),cameraList)
        return rooteView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        setting.setOnClickListener {
            navController.navigate(R.id.action_listFragment_to_settingsFragment)
        }
    }
    companion object {

        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}