package com.exemplo.coraleatoria

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

/**
 * Tela principal: um botão no centro que, a cada clique,
 * pinta o fundo da tela com uma cor aleatória.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tela = findViewById<View>(R.id.tela)
        val botao = findViewById<Button>(R.id.botao)

        botao.setOnClickListener {
            tela.setBackgroundColor(corAleatoria())
        }
    }

    /** Sorteia valores de 0 a 255 para vermelho, verde e azul. */
    private fun corAleatoria(): Int {
        val vermelho = Random.nextInt(256)
        val verde = Random.nextInt(256)
        val azul = Random.nextInt(256)
        return Color.rgb(vermelho, verde, azul)
    }
}
