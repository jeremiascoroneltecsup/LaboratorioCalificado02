package com.coronel.jeremias.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class pedido : AppCompatActivity() {

    private lateinit var tvNombreCliente: TextView
    private lateinit var tvNumeroCliente: TextView
    private lateinit var tvProductos: TextView
    private lateinit var tvUbicacion: TextView
    private lateinit var btnLlamar: Button
    private lateinit var btnWSP: Button
    private lateinit var btnMaps: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        // Inicialización de las vistas
        tvNombreCliente = findViewById(R.id.tvNombreCliente)
        tvNumeroCliente = findViewById(R.id.tvNumeroCliente)
        tvProductos = findViewById(R.id.tvProductos)
        tvUbicacion = findViewById(R.id.tvUbicacion)
        btnLlamar = findViewById(R.id.btnLlamar)
        btnWSP = findViewById(R.id.btnWSP)
        btnMaps = findViewById(R.id.btnMaps)

        // Obtener datos del Intent
        val nombre = intent.getStringExtra("NOMBRE_CLIENTE")
        val numero = intent.getStringExtra("NUMERO_CLIENTE")
        val productos = intent.getStringExtra("PRODUCTOS")
        val ubicacion = intent.getStringExtra("UBICACION")

        // Asignar los datos a las vistas
        tvNombreCliente.text = nombre ?: "Nombre no disponible"
        tvNumeroCliente.text = numero ?: "Número no disponible"
        tvProductos.text = productos ?: "Productos no disponibles"
        tvUbicacion.text = ubicacion ?: "Ubicación no disponible"

        // Configuración de los botones de acción
        btnLlamar.setOnClickListener {
            realizarLlamada()
        }

        btnWSP.setOnClickListener {
            enviarWhatsApp(nombre, productos, ubicacion)
        }

        btnMaps.setOnClickListener {
            abrirMaps()
        }
    }

    private fun realizarLlamada() {
        val numero = tvNumeroCliente.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$numero")
        startActivity(intent)
    }

    private fun enviarWhatsApp(nombre: String?, productos: String?, ubicacion: String?) {
        val numero = tvNumeroCliente.text.toString().replace("+51", "51") // Formato para WhatsApp
        // Crear el mensaje personalizado
        val mensaje = "Hola $nombre, tus productos: $productos están en camino a la dirección: $ubicacion."
        val uri = Uri.parse("https://api.whatsapp.com/send?phone=$numero&text=${Uri.encode(mensaje)}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun abrirMaps() {
        val ubicacion = tvUbicacion.text.toString()
        val uri = Uri.parse("geo:0,0?q=$ubicacion")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps") // Asegurarse de que Maps esté instalado
        startActivity(intent)
    }
}


