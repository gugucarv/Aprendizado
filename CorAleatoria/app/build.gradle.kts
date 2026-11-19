// Configuração de compilação do módulo "app" (o app propriamente dito).
// O Gradle lê este arquivo para saber como transformar o código em APK.

// Plugins são extensões que ensinam o Gradle a compilar certos tipos de projeto.
plugins {
    id("com.android.application")      // Ensina a gerar um app Android (APK).
    id("org.jetbrains.kotlin.android") // Ensina a compilar código Kotlin para Android.
} // Fim dos plugins.

// Bloco com as configurações específicas do Android.
android {
    // Pacote onde fica o código; é o mesmo do "package" do MainActivity.kt.
    namespace = "com.exemplo.coraleatoria"
    // Versão do Android usada para compilar (35 = Android 15).
    compileSdk = 35

    // Configurações que vão para dentro do APK.
    defaultConfig {
        // Identidade única do app no celular e na Play Store.
        applicationId = "com.exemplo.coraleatoria"
        // Versão mínima do Android que consegue instalar o app (21 = Android 5.0).
        minSdk = 21
        // Versão do Android para a qual o app foi testado e otimizado.
        targetSdk = 35
        // Número interno da versão; aumenta a cada atualização publicada.
        versionCode = 1
        // Versão que o usuário vê, por exemplo "1.0".
        versionName = "1.0"
    } // Fim do defaultConfig.

    // Tipos de compilação (debug para testes, release para publicar).
    buildTypes {
        // Configuração da versão final (release).
        release {
            // false = não encolhe nem embaralha o código (mais simples para aprender).
            isMinifyEnabled = false
        } // Fim do release.
    } // Fim do buildTypes.

    // Versão da linguagem Java usada ao compilar.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // Lê o código como Java 17.
        targetCompatibility = JavaVersion.VERSION_17 // Gera código compatível com Java 17.
    } // Fim do compileOptions.
    // Mesma coisa para o Kotlin: gera código compatível com Java 17.
    kotlinOptions {
        jvmTarget = "17"
    } // Fim do kotlinOptions.
} // Fim do bloco android.

// Bibliotecas externas que o app usa.
dependencies {
    // AppCompat: dá a classe AppCompatActivity e o tema usado no app.
    implementation("androidx.appcompat:appcompat:1.7.0")
} // Fim das dependências.
