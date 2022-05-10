package com.example.zoofarm

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainListView = findViewById<ListView>(R.id.listview_main)

        mainListView.adapter = MyCustomAdapter(this)
    }

    private class MyCustomAdapter(context:Context):BaseAdapter(){
        val myContext:Context = context

        //Data Source
        val names = arrayOf("Baboon", "Bull Dog", "Panda", "Swallow Bird", "White Tiger", "Zebra")
        val pic = arrayOf(
            R.drawable.baboon, R.drawable.bulldog, R.drawable.panda, R.drawable.swallow_bird, R.drawable.white_tiger,
            R.drawable.zebra
        )
        override fun getCount(): Int {
            return names.size
        }

        override fun getItem(position: Int): Any {
            return position.toLong()
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val layoutInflater = LayoutInflater.from(myContext)
            val rowLayout = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
            val animalName = rowLayout.findViewById<TextView>(R.id.animal_name)
            animalName.text = names[position]
            val animalPic = rowLayout.findViewById<ImageView>(R.id.animal_pic)
            animalPic.setImageResource(pic[position])

            return rowLayout
//            val textView = TextView(myContext)
//            textView.text = "Hello William"
//            return textView
        }
    }
}