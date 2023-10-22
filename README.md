
# App Android Jogos Brasil

Este é o repositório do projeto Jogos Brasil, que foi criado como parte de um desafio do Bootcamp Kotlin da DIO.
Neste projeto, foi desenvolvido um aplicativo Android para acompanhar as partidas do Brasil.
Este aplicativo lista as partidas e fornece notificações push para lembretes.

# Features
- Lista de partidas: Você pode ver todas as partidas da seleção brasileira, com as datas, os horários e os adversários.
- Notificações: Você pode habilitar ou desabilitar as notificações para receber alertas das partidas.

## API

Os dados das partidas são obtidos por uma Pseudo-API criada usando o GitHub Pages, a qual está disponível na seguinte URL: [API jogos do Brasil](https://digitalinnovationone.github.io/copa-2022-android/api.json)

## Desafio de Projeto 😎

Aqui estão os principais objetivos deste desafio:

1. :white_large_square: Projeto Base

   - **app**: Este módulo contém as classes de nível de aplicativo e scaffolding que vinculam o restante da base de código.

   - **data**: Abstração para o acesso a fontes de dados, organizada da seguinte forma:

      - ***data***: Neste módulo são declarados os DataSources "remote" e "local", bem como a implementação dos repositórios de acordo com a lógica de negócio necessária.

      - ***local***: Contém uma implementação do [Room](https://developer.android.com/training/data-storage/room) como fonte de dados local.

      - ***remote***: Implementação de uma fonte de dados remota usando o [Retrofit](https://square.github.io/retrofit/) como cliente HTTP.

   - **domain**: Neste módulo são declarados os casos de uso (funcionalidades) da aplicação.

   - **notification-scheduler**: Módulo específico para a criação das Notificações via Work Manager.

2. :white_large_square: UseCase
- Buscar lista das partidas: `'GetMatchesUseCase.kt`
- Habilitar notificação: `EnableNotificationUseCase.kt`
- Desabilitar notificação: `DisableNotificationUseCase.kt`

3. :white_large_square: ViewModel: 

   - `MainViewModel.kt` para orquestrar as interações com a `MainActivity.kt`.

4. :white_large_square: Compose MainScreen 

   - `MainScreen.kt` para criar a UI por meio do Jetpack Compose.

5. :white_large_square: Integração 

   - Entre ViewModel e Activity, através da observação de estados.

6. :white_large_square: WorkManager 
   - Orquestração das Notificações Push localmente.


