package com.coronel.jeremias.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity





class Ejercicio01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        val greenView: View = findViewById(R.id.viewVerde)
        val buttonShow: Button = findViewById(R.id.buttonMostrar)
        val buttonHide: Button = findViewById(R.id.buttonOcultar)

        buttonShow.setOnClickListener {
            greenView.visibility = View.VISIBLE
        }

        buttonHide.setOnClickListener {
            greenView.visibility = View.GONE
        }
    }
}