package com.maeruiz.designsystem.theme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val Purple200 = Color(0xFFBB86FC)
private val Purple500 = Color(0xFF6200EE)
private val Purple700 = Color(0xFF3700B3)

private val Teal200 = Color(0xFF03DAC5)
private val Teal700 = Color(0xFF018786)

private val Black = Color(0xFF000000)
private val White = Color(0xFFFFFFFF)

//RelayColors
internal val RelayTeal700 = Color(0xFF018786)
internal val RelayTeal200 = Color(0xFF03DAC5)

internal val RelayPurple500 = Color(0xFF6200EE)
internal val RelayPurple200 = Color(0xFFBB86FC)

// Light scheme
val primaryLight = Purple500
val onPrimaryLight = White
val primaryContainerLight = Purple200
val onPrimaryContainerLight = Black
val inversePrimaryLight = Purple200

val secondaryLight = Teal700
val onSecondaryLight = Black
val secondaryContainerLight = Teal200
val onSecondaryContainerLight = Black

// Dark scheme
val primaryDark = Purple200
val onPrimaryDark = Black
val primaryContainerDark = Purple700
val onPrimaryContainerDark = White
val inversePrimaryDark = Purple500

val secondaryDark = Teal200
val onSecondaryDark = Black
val secondaryContainerDark = Teal700
val onSecondaryContainerDark = Black

internal val RunnerLightColorScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    // Existing tertiary, error and surface roles
)

internal val RunnerDarkColorScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    // Existing tertiary, error and surface roles
)






