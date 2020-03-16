package com.example.dogapiv2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.dogs_activity_list.*

class DogsActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dogs_activity_list)
        rcvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        val intent = this.intent
        var raza = intent.getStringExtra("RAZA").toLowerCase()
        txtHeader.text = "Raza del Perro: "+raza
        RequestVolley("https://dog.ceo/api/breed/"+raza+"/images")
    }

    private fun RequestVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET, url, Response.Listener<String> {
                response ->
            try {
                val gson = Gson()
                val listDogs = gson.fromJson(response,DogsModel::class.java)
                val adaptador = DogAdapter(listDogs.message!!)
                println(adaptador)
                println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
                rcvList.adapter = adaptador
            } catch (e: Exception) {

            }
        }, Response.ErrorListener {  })
        queue.add(request)
    }
}
