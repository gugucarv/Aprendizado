// "package" diz em qual pacote (pasta lógica) este arquivo mora.
// Ele precisa bater com o "namespace" definido em app/build.gradle.kts.
package com.exemplo.coraleatoria

// "import" traz ferramentas prontas de outras bibliotecas para usarmos aqui.
import android.graphics.Color                  // Classe do Android para criar e usar cores.
import android.os.Bundle                       // Pacote de dados que o Android entrega ao abrir a tela.
import android.view.View                       // "View" é qualquer elemento visível na tela.
import android.widget.TextView                 // TextView é um elemento que mostra texto.
import androidx.appcompat.app.AppCompatActivity // Classe base de uma tela (Activity) moderna.
import kotlin.random.Random                    // Gerador de números aleatórios do Kotlin.

/**
 * Tela principal: a cada toque em qualquer lugar da tela, o fundo
 * muda para uma cor aleatória e aparece o código da cor.
 */
// "class MainActivity" cria a nossa tela.
// ": AppCompatActivity()" significa que ela herda tudo o que uma tela do Android já sabe fazer.
class MainActivity : AppCompatActivity() {

    // onCreate é chamado pelo Android uma vez, quando a tela é criada (ao abrir o app).
    // "override" indica que estamos substituindo a versão padrão dessa função.
    override fun onCreate(savedInstanceState: Bundle?) {
        // Executa primeiro o onCreate original da classe mãe (obrigatório).
        super.onCreate(savedInstanceState)
        // Diz qual layout desenhar: o arquivo res/layout/activity_main.xml.
        setContentView(R.layout.activity_main)

        // Procura no layout o elemento com id "tela" (o fundo inteiro) e guarda na variável "tela".
        // "val" cria uma variável que não muda de valor depois.
        val tela = findViewById<View>(R.id.tela)
        // Procura o texto grande do centro, onde vai aparecer o código da cor.
        val codigo = findViewById<TextView>(R.id.codigo)
        // Procura o texto do rodapé (onde está escrito "gugucarv").
        val rodape = findViewById<TextView>(R.id.rodape)

        // Define o que acontece quando alguém toca na tela.
        // Tudo entre as chaves { } roda a cada toque.
        tela.setOnClickListener {
            // Sorteia um número de 0 a 255 para a quantidade de vermelho.
            val vermelho = Random.nextInt(256)
            // Sorteia um número de 0 a 255 para a quantidade de verde.
            val verde = Random.nextInt(256)
            // Sorteia um número de 0 a 255 para a quantidade de azul.
            val azul = Random.nextInt(256)
            // Junta as três quantidades numa única cor (sistema RGB: Red, Green, Blue).
            val cor = Color.rgb(vermelho, verde, azul)

            // Pinta o fundo da tela com a cor sorteada.
            tela.setBackgroundColor(cor)
            // Monta o código da cor em hexadecimal, por exemplo "#3FA2C8":
            //   "#"    -> o caractere # no começo
            //   "%02X" -> um número em hexadecimal (X = letras maiúsculas),
            //             sempre com 2 dígitos (02 = completa com zero à esquerda)
            // Repetimos "%02X" três vezes: um para vermelho, um para verde e um para azul.
            codigo.text = String.format("#%02X%02X%02X", vermelho, verde, azul)

            // Escolhe a cor do texto para ele ficar sempre legível:
            // se o fundo for claro, texto preto; se for escuro, texto branco.
            // "if (...) A else B" devolve A quando a condição é verdadeira e B quando é falsa.
            val corTexto = if (ehClara(vermelho, verde, azul)) Color.BLACK else Color.WHITE
            // Aplica essa cor ao texto do código.
            codigo.setTextColor(corTexto)
            // Aplica a mesma cor ao texto do rodapé.
            rodape.setTextColor(corTexto)
        } // Fim do que acontece a cada toque.
    } // Fim do onCreate.

    /** Calcula o brilho percebido pelo olho humano (0 a 255). */
    // "private" quer dizer que só esta classe pode usar a função.
    // Ela recebe as três partes da cor (r, g, b) e devolve "Boolean" (true ou false).
    private fun ehClara(r: Int, g: Int, b: Int): Boolean {
        // Fórmula de brilho: o olho humano enxerga o verde como mais claro,
        // o vermelho um pouco menos e o azul bem menos; por isso os pesos diferentes.
        val brilho = 0.299 * r + 0.587 * g + 0.114 * b
        // Se o brilho passar de 150 (de um máximo de 255), consideramos a cor clara.
        return brilho > 150
    } // Fim da função ehClara.
} // Fim da classe MainActivity.
