package com.maeruiz.home.presentation

object DummyHomeData {
    val homeUiState = HomeUiState(
        runnerName = "Maely",
        weeklyDistance = "12,4 km",
        weeklyGoal = "20 km",
        weeklyProgress = 0.62f,
        recentRuns = listOf(
            RecentRunUiModel(
                id = "1",
                title = "Carrera matutina",
                distance = "5,2 km",
                duration = "29:40",
                pace = "5:42 min/km",
            ),
            RecentRunUiModel(
                id = "2",
                title = "Entrenamiento de intervalos",
                distance = "4,1 km",
                duration = "24:12",
                pace = "5:54 min/km",
            ),
            RecentRunUiModel(
                id = "3",
                title = "Carrera suave",
                distance = "3,1 km",
                duration = "19:08",
                pace = "6:10 min/km",
            ),
        ),
    )
}