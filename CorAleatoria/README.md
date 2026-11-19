# Cor Aleatória (Android)

App Android simples: a cada toque em qualquer lugar da tela, o fundo muda para uma cor aleatória e aparece o código da cor (ex.: `#3FA2C8`). O texto fica claro ou escuro conforme o fundo, para ser sempre legível.

## Como rodar

1. Abra a pasta `CorAleatoria` no **Android Studio** (File > Open).
2. Espere o Gradle sincronizar.
3. Conecte um celular (com depuração USB ativada) ou crie um emulador.
4. Clique em **Run ▶**.

## Onde está o código

- `app/src/main/java/com/exemplo/coraleatoria/MainActivity.kt`: o sorteio da cor e o contraste do texto.
- `app/src/main/res/layout/activity_main.xml`: o layout da tela (código da cor e rodapé).
