package com.example.dogapiv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        searchBtn.setOnClickListener {
            if (Network.hayRed(this)) {
                val intLista = Intent(this,DogsActivity::class.java)
                intLista.putExtra("RAZA",edtxtRaza.text.toString())
                startActivity(intLista)
            }else{
                Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
            }
        }
    }
}
