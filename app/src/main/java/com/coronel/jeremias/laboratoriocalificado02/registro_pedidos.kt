package com.coronel.jeremias.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class registro_pedidos : AppCompatActivity() {

    private lateinit var etNombreCliente: EditText
    private lateinit var etNumeroCliente: EditText
    private lateinit var etProductos: EditText
    private lateinit var etUbicacion: EditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pedidos)

        // Inicialización de las vistas
        etNombreCliente = findViewById(R.id.etNombreCliente)
        etNumeroCliente = findViewById(R.id.etNumeroCliente)
        etProductos = findViewById(R.id.etProductos)
        etUbicacion = findViewById(R.id.etDireccion)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        // Configuración del botón de registrar
        btnRegistrar.setOnClickListener {
            registrarPedido()
        }
    }

    private fun registrarPedido() {
        val nombre = etNombreCliente.text.toString()
        val numero = etNumeroCliente.text.toString()
        val productos = etProductos.text.toString()
        val ubicacion = etUbicacion.text.toString()

        // Crear un Intent para pasar los datos a la actividad pedido
        val intent = Intent(this, pedido::class.java).apply {
            putExtra("NOMBRE_CLIENTE", nombre)
            putExtra("NUMERO_CLIENTE", numero)
            putExtra("PRODUCTOS", productos)
            putExtra("UBICACION", ubicacion)
        }
        startActivity(intent)
    }
}
