package com.maeruiz.firstkm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.maeruiz.designsystem.theme.RunnerTheme
import com.maeruiz.home.presentation.HomeRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RunnerTheme {
                HomeRoute(
                    onStartRun = { /* TODO */ },
                    onViewHistory = { /* TODO */ }
                )
            }
        }
    }
}
