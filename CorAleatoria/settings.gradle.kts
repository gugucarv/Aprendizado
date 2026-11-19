// Primeiro arquivo que o Gradle lê: diz onde baixar as coisas e quais módulos existem.

// Onde o Gradle procura os plugins (as extensões de compilação).
pluginManagement {
    repositories {
        google()             // Repositório do Google (plugins do Android).
        mavenCentral()       // Repositório público principal de bibliotecas Java/Kotlin.
        gradlePluginPortal() // Portal oficial de plugins do Gradle.
    } // Fim dos repositórios de plugins.
} // Fim do pluginManagement.

// Onde o Gradle procura as bibliotecas usadas pelo app.
dependencyResolutionManagement {
    // Obriga todos os módulos a usarem só os repositórios listados aqui.
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()       // Bibliotecas do Google (como o AppCompat).
        mavenCentral() // Demais bibliotecas públicas.
    } // Fim dos repositórios de bibliotecas.
} // Fim do dependencyResolutionManagement.

// Nome do projeto.
rootProject.name = "CorAleatoria"
// Inclui o módulo "app" (a pasta app/) na compilação.
include(":app")
