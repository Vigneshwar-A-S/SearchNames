package com.example.searchnames

import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import java.util.ArrayList
import java.util.Arrays
import java.util.Collections
import java.util.Comparator
import android.os.Bundle as Bundle1

class MainActivity:AppCompatActivity() {
    internal lateinit var nameList:Array<String>
    internal lateinit var names:ArrayList<String>
    internal lateinit var adapter:ArrayAdapter<String>
    internal lateinit var editText:EditText
    internal lateinit var listView:ListView
    internal lateinit var button:Button


        override fun onCreate(savedInstanceState: Bundle1?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edit_text)
        listView = findViewById(R.id.listView)
        button = findViewById(R.id.button)
        nameList = arrayOf<String>("Vigneshwar", "Varsha", "Liam", "Emma", "Noah", 
            "Olivia", "Jack", "Riley", "Luke", "Zoey", "Jayden", "Nora", 
            "Grayson", "Eleanor", "Isaac", "Lillian", "Julian", "Aubrey", 
            "Mateo", "Ellie", "Anthony", "Stella", "Jaxon", "Natalie", "Joshua", 
            "Leah", "Christopher", "Hazel", "Andrew", "Violet", "Theodore", "Aurora", 
            "Caleb", "Savannah", "William", "Ava", "James", "Isabella", "Oliver", 
            "Sophia", "Benjamin", "Charlotte", "Elijah", "Mia", "Lucas", "Amelia", 
            "Mason", "Haper", "Logan", "Evelyn", "Alexander", "Abigail", "Ethan", 
            "Emily", "Jacob", "Elizabeth", "Michael", "Mila", "Daniel", "Ella", "Henry", 
            "Avery", "Jackson", "Sofia", "Sebastian", "Camila", "Aiden", "Aria", 
            "Matthew", "Scarlett", "Samuel", "Victoria", "David", "Madison", "Joseph", 
            "Luna", "Carter", "Grace", "Owen", "Chloe", "Wyatt", "Penelope", "Asher", 
            "Brooklyn", "Nathan", "Bella", "Thomas", "Claire", "Leo", "Skylar", 
            "Isaiah", "Lucy", "Charles", "Paisley", "Josiah", "Everly", "Hudson", 
            "Anna", "Christian", "Caroline", "Hunter", "Nova")
        
        names = ArrayList<String>(Arrays.asList<String>(*nameList))
        adapter = ArrayAdapter(this, R.layout.list_item, R.id.txt_item, names)
        listView.setAdapter(adapter)
        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view:View) {
                Arrays.sort(arrayOf<ArrayList<*>>(names))
                adapter.notifyDataSetChanged()
                sortArrayList()
            }
        })
        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(charSequence:CharSequence, i:Int, i1:Int, i2:Int) {
            }
            override fun onTextChanged(charSequence:CharSequence, i:Int, i1:Int, i2:Int) {
                (this@MainActivity).adapter.getFilter().filter(charSequence)
            }
            override fun afterTextChanged(editable:Editable) {
            }
        })
    }
    private fun sortArrayList() {
        Collections.sort<String>(names, object:Comparator<String> {
            public override fun compare(s:String, t1:String):Int {
                return s.compareTo(t1)
            }
        })
        adapter.notifyDataSetChanged()
    }
}