package com.example.gottalearn_beta

import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.time.hours


class ExampleAdapter : ListAdapter<Assignment, ExampleAdapter.ExampleViewHolder>(ASSIGNMENT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        return  ExampleViewHolder.create(parent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem=getItem(position)

        holder.imageView.setImageResource(signImage(currentItem.priority))
        holder.textView1.text=currentItem.title
        holder.textView2.text=currentItem.date
        holder.line.setBackgroundResource(lineBackgorund(currentItem.subject))



    }


    class ExampleViewHolder (itemView: View): RecyclerView.ViewHolder (itemView){
        val imageView: ImageView =itemView.findViewById(R.id.bookmark)
        val textView1: TextView=itemView.findViewById(R.id.text_view1)
        val textView2: TextView=itemView.findViewById(R.id.text_view2)
        val line: View=itemView.findViewById(R.id.line)

        companion object{
            fun create(parent: ViewGroup): ExampleViewHolder{
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.example_item, parent, false)
                return ExampleViewHolder(view)
            }
        }
    }

    private fun signImage(input:String):Int{
        val drawable= when (input){
            "Low"-> R.drawable.ic_bookmark_green
            "High"-> R.drawable.ic_bookmark_orange
            "Medium"-> R.drawable.ic_bookmark_yellow
            else -> R.drawable.ic_bookmark_red
        }
        return drawable
    }

    private fun lineBackgorund(subject: String):Int{
        val color= when (subject){
            "APSI"->R.color.Apsi_Color
            "PPB"-> R.color.PPB_Color
            "PPL1"-> R.color.PPL1_Color
            "Proyek4"-> R.color.Proyek4_Color
            "Pancasila"-> R.color.Pancasila_Color
            else -> R.color.Statpro_Color
        }

        return color
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun dueDate(date1:LocalDate): String{
        val currentDateTime = LocalDate.now()
        val days = ChronoUnit.DAYS.between(date1,currentDateTime)
        val hours=ChronoUnit.HOURS.between(date1,currentDateTime)-(days*24)

        return "$days"+"d"+" $hours"+"h"

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun stringToDate(input: String):LocalDate{
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US)
        val date = LocalDate.parse(input, formatter)

        return date
    }

    companion object {
        private val ASSIGNMENT_COMPARATOR = object : DiffUtil.ItemCallback<Assignment>() {
            override fun areItemsTheSame(oldItem: Assignment, newItem: Assignment): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Assignment, newItem: Assignment): Boolean {
                return oldItem.title== newItem.title
            }
        }
    }




}