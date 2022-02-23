package br.com.myapplication0

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clear = intent.getBooleanExtra("clear", false)
        if(clear) {
            val editText = findViewById<EditText>(R.id.editTextMain)
            editText.text.clear()
            editText.requestFocus()
        }

        val enviar = findViewById<Button>(R.id.btn_enviar)

        enviar.setOnClickListener {
            enviarPergunta()
        }
    }

    private fun enviarPergunta() {
        val editText = findViewById<EditText>(R.id.editTextMain)
        val pergunta = editText.text.toString()

            val intent = Intent(this, Resposta::class.java).apply {
                putExtra("pergunta", pergunta)

            startActivity(intent)
        }


    }
}