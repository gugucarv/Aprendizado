// Arquivo de compilação da raiz do projeto.
// Aqui só declaramos quais plugins (e versões) o projeto pode usar.
// "apply false" = não usa aqui na raiz; cada módulo (como "app") decide se usa.
plugins {
    // Plugin do Android (Android Gradle Plugin), versão 8.7.3.
    id("com.android.application") version "8.7.3" apply false
    // Plugin do Kotlin para Android, versão 2.0.21.
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
} // Fim dos plugins.
