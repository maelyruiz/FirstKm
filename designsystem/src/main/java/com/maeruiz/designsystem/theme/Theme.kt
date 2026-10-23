package com.maeruiz.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun RunnerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colorScheme = if (darkTheme) {
        RunnerDarkColorScheme
    } else {
        RunnerLightColorScheme
    }

    val relayColors = if (darkTheme) {
        DarkRelayColors
    } else {
        LightRelayColors
    }

    CompositionLocalProvider(
        LocalRelayColors provides relayColors,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = RunnerTypography,
            content = content,
        )
    }
}

