package com.maeruiz.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class RelayColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
)

internal val LightRelayColors = RelayColors(
    primary = RelayTeal700,
    onPrimary = Color.Black,
    secondary = RelayPurple500,
    onSecondary = Color.White,
)

internal val DarkRelayColors = RelayColors(
    primary = RelayTeal200,
    onPrimary = Color.Black,
    secondary = RelayPurple200,
    onSecondary = Color.Black,
)

internal val LocalRelayColors = staticCompositionLocalOf {
    LightRelayColors
}

object RelayTheme {

    val colors: RelayColors
        @Composable
        @ReadOnlyComposable
        get() = LocalRelayColors.current
}