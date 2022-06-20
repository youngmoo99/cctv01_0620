package com.example.intelligentcctv101.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.intelligentcctv101.R

class CameraAdapter (val context:Context, val cameraList: ArrayList<Camera>) : RecyclerView.Adapter<CameraAdapter.CustomViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraAdapter.CustomViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_camera,parent,false)
        return CustomViewHolder(view)

    }

    override fun onBindViewHolder(holder: CameraAdapter.CustomViewHolder, position: Int) {
        holder.camimage.setImageResource(cameraList.get(position).camera_image)
        holder.camname.text = cameraList.get(position).camera_name
        holder.portnumvalue.text = cameraList.get(position).port_num_value.toString()
        holder.ipaddressvalue.text = cameraList.get(position).ip_address_value


    }

    override fun getItemCount(): Int {
        return cameraList.size

    }
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val camimage = itemView.findViewById<ImageView>(R.id.cam_profile) // 캠 이미지
        val camname = itemView.findViewById<TextView>(R.id.cam_name) // 카메라이름
        val portnumvalue = itemView.findViewById<TextView>(R.id.port_value) // 포트번호 값
        val ipaddressvalue = itemView.findViewById<TextView>(R.id.ip_address_value) // ip주소값

    }

}