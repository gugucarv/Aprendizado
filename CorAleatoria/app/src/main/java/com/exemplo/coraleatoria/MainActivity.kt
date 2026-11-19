package com.exemplo.coraleatoria

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

/**
 * Tela principal: a cada toque em qualquer lugar da tela, o fundo
 * muda para uma cor aleatória e aparece o código da cor.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tela = findViewById<View>(R.id.tela)
        val codigo = findViewById<TextView>(R.id.codigo)
        val rodape = findViewById<TextView>(R.id.rodape)

        tela.setOnClickListener {
            val vermelho = Random.nextInt(256)
            val verde = Random.nextInt(256)
            val azul = Random.nextInt(256)
            val cor = Color.rgb(vermelho, verde, azul)

            tela.setBackgroundColor(cor)
            codigo.text = String.format("#%02X%02X%02X", vermelho, verde, azul)

            // Texto escuro em fundo claro e texto claro em fundo escuro.
            val corTexto = if (ehClara(vermelho, verde, azul)) Color.BLACK else Color.WHITE
            codigo.setTextColor(corTexto)
            rodape.setTextColor(corTexto)
        }
    }

    /** Calcula o brilho percebido pelo olho humano (0 a 255). */
    private fun ehClara(r: Int, g: Int, b: Int): Boolean {
        val brilho = 0.299 * r + 0.587 * g + 0.114 * b
        return brilho > 150
    }
}
