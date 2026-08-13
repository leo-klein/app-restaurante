package br.gov.sp.etec.app_restaurante

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvContador = findViewById<TextView>(R.id.tvContador)
        val textContador = findViewById<TextView>(R.id.textContador)
        val btnEntrar = findViewById<Button>(R.id.buttonEntrar)
        val btnSair = findViewById<Button>(R.id.buttonSair)

        fun atualizarStatus() {
            if (contador >= 10) {
                textContador.text = "Lotado!"
            } else {
                textContador.text = "Pode Entrar!"
            }
        }

        btnEntrar.setOnClickListener {
            contador++
            tvContador.text = contador.toString()
            atualizarStatus()
        }

        btnSair.setOnClickListener {
            if (contador > 0) {
                contador--
            }
            tvContador.text = contador.toString()
            atualizarStatus()
        }
    }
}