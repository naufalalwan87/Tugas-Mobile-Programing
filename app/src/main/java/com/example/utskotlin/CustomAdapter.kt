package com.example.utskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user: User=userList[position]
        holder?.textViewName?.text = user.name
        holder?.textViewttl?.text = user.ttl
        holder?.textViewhp?.text = user.hp
        holder?.textViewalamat?.text = user.address

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }


    override fun getItemCount(): Int {

        return userList.size
    }



    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewName = itemView.findViewById(R.id.textViewName) as TextView
        val textViewttl = itemView.findViewById(R.id.textViewttl) as TextView
        val textViewhp = itemView.findViewById(R.id.textViewhp) as TextView
        val textViewalamat = itemView.findViewById(R.id.textViewalamat) as TextView





    }
}

