package com.exemplo.coraleatoria

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

/**
 * Tela principal: a cada toque em qualquer lugar da tela, o fundo
 * muda para uma cor aleatória e aparecem o código e o nome da cor.
 */
class MainActivity : AppCompatActivity() {

    /** Cores com nome conhecido, usadas para achar o nome mais parecido. */
    private val coresConhecidas = listOf(
        "Preto" to 0x000000, "Branco" to 0xFFFFFF, "Cinza" to 0x808080,
        "Cinza-claro" to 0xC0C0C0, "Cinza-escuro" to 0x404040,
        "Vermelho" to 0xFF0000, "Vinho" to 0x800000, "Rosa" to 0xFFC0CB,
        "Pink" to 0xFF1493, "Salmão" to 0xFA8072, "Coral" to 0xFF7F50,
        "Laranja" to 0xFFA500, "Pêssego" to 0xFFDAB9, "Marrom" to 0x8B4513,
        "Bege" to 0xF5F5DC, "Caramelo" to 0xD2691E, "Dourado" to 0xFFD700,
        "Amarelo" to 0xFFFF00, "Creme" to 0xFFFDD0, "Oliva" to 0x808000,
        "Verde-limão" to 0x32CD32, "Verde" to 0x008000, "Verde-escuro" to 0x006400,
        "Verde-claro" to 0x90EE90, "Menta" to 0x98FF98, "Verde-água" to 0x7FFFD4,
        "Turquesa" to 0x40E0D0, "Ciano" to 0x00FFFF, "Azul-petróleo" to 0x008080,
        "Azul-céu" to 0x87CEEB, "Azul-claro" to 0xADD8E6, "Azul" to 0x0000FF,
        "Azul-royal" to 0x4169E1, "Azul-marinho" to 0x000080, "Índigo" to 0x4B0082,
        "Roxo" to 0x800080, "Violeta" to 0xEE82EE, "Lilás" to 0xC8A2C8,
        "Lavanda" to 0xE6E6FA, "Magenta" to 0xFF00FF,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tela = findViewById<View>(R.id.tela)
        val codigo = findViewById<TextView>(R.id.codigo)
        val nome = findViewById<TextView>(R.id.nome)
        val rodape = findViewById<TextView>(R.id.rodape)

        tela.setOnClickListener {
            val vermelho = Random.nextInt(256)
            val verde = Random.nextInt(256)
            val azul = Random.nextInt(256)
            val cor = Color.rgb(vermelho, verde, azul)

            tela.setBackgroundColor(cor)
            codigo.text = String.format("#%02X%02X%02X", vermelho, verde, azul)
            nome.text = nomeMaisParecido(vermelho, verde, azul)

            // Texto escuro em fundo claro e texto claro em fundo escuro.
            val corTexto = if (ehClara(vermelho, verde, azul)) Color.BLACK else Color.WHITE
            codigo.setTextColor(corTexto)
            nome.setTextColor(corTexto)
            rodape.setTextColor(corTexto)
        }
    }

    /** Calcula o brilho percebido pelo olho humano (0 a 255). */
    private fun ehClara(r: Int, g: Int, b: Int): Boolean {
        val brilho = 0.299 * r + 0.587 * g + 0.114 * b
        return brilho > 150
    }

    /** Procura na lista a cor conhecida mais próxima da cor sorteada. */
    private fun nomeMaisParecido(r: Int, g: Int, b: Int): String {
        return coresConhecidas.minBy { (_, rgb) ->
            val dr = r - (rgb shr 16 and 0xFF)
            val dg = g - (rgb shr 8 and 0xFF)
            val db = b - (rgb and 0xFF)
            dr * dr + dg * dg + db * db
        }.first
    }
}
