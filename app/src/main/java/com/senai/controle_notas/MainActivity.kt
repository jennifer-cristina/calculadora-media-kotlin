package com.senai.controle_notas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private lateinit var nota1EditText: EditText
private lateinit var nota2EditText: EditText
private lateinit var nomeEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Chamando o conteúdo da TextView pelo id e colocando em uma variável
        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        // Ouvir e pegar os dados ao clicar no botão calcular
        calcular.setOnClickListener(){

            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)
            nomeEditText = findViewById(R.id.nome)

            val resultadoTextView = findViewById<TextView>(R.id.resultado)

            if(validarCampos()) {

                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()

                val media = calcularMedia(nota1, nota2)

//              resultadoTextView.text = situacaoAluno(media)

                // classe responsável por chamar a classe ResultadoActivity
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("nome", nomeEditText.text.toString())
                intent.putExtra("nota1", "${nota1}")
                intent.putExtra("nota2", nota2.toString())
                intent.putExtra("media", media.toString())
                intent.putExtra("situacao", situacaoAluno(media))
                startActivity(intent)

            }
        }
        // Ouvir o usuário quando ele clicar no botão clicar
        sair.setOnClickListener(){
            finish()
        }
    }


//  fun calcularMedia(nota1: Int, nota2: Int): Int {
//        return (nota1 + nota2) / 2
//    }

//    fun calcularMedia(nota1: Int, nota2: Int): Int =  (nota1 + nota2) / 2

//    val calcularMedia = {nota1: Int, nota2: Int -> (nota1 + nota2) / 2}


    private fun validarCampos(): Boolean {
                var noError = true
                if(nota1EditText.text.isBlank()){
                    nota1EditText.setError("Digite a nota 1!")
                    noError = false
                }

                if(nota2EditText.text.isBlank()){
                    nota2EditText.setError("Digite a nota 2!")
                    noError = false
                }

                if(nomeEditText.text.isBlank()) {
                    nomeEditText.setError("Digite o nome do aluno!")
                    noError = false
                }

                return noError
            }
}