package com.senai.controle_notas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val nomeTextView = findViewById<TextView>(R.id.nome)
        val nota1TextView = findViewById<TextView>(R.id.nota1)
        val nota2TextView = findViewById<TextView>(R.id.nota2)
        val mediaTextView = findViewById<TextView>(R.id.media)
        val situacaoTextView = findViewById<TextView>(R.id.situacao)

        // descreve a atividade a iniciar e carrega todos os dados necessários.
        val intent:Intent = getIntent()

        val actionBar = supportActionBar

        actionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        nomeTextView.text = intent.getStringExtra("nome")
        nota1TextView.text = intent.getStringExtra("nota1")
        nota2TextView.text = intent.getStringExtra("nota2")
        mediaTextView.text = intent.getStringExtra("media")
        situacaoTextView.text = intent.getStringExtra("situacao")

    }
}