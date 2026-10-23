package com.maeruiz.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maeruiz.designsystem.components.RelayButton
import com.maeruiz.home.R

data class HomeUiState(
    val runnerName: String,
    val weeklyDistance: String,
    val weeklyGoal: String,
    val weeklyProgress: Float,
    val recentRuns: List<RecentRunUiModel>,
)

data class RecentRunUiModel(
    val id: String,
    val title: String,
    val distance: String,
    val duration: String,
    val pace: String,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onStartRun: () -> Unit,
    onViewHistory: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Surface(modifier = modifier.fillMaxSize()) {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            Text(
                                text = stringResource(R.string.home_greeting, uiState.runnerName),
                                modifier = Modifier.semantics { heading() },
                                style = MaterialTheme.typography.headlineMedium,
                            )

                            Text(
                                text = stringResource(R.string.home_motivation),
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                    }

                    item {
                        WeeklyGoalCard(
                            distance = uiState.weeklyDistance,
                            goal = uiState.weeklyGoal,
                            progress = uiState.weeklyProgress,
                        )
                    }

                    item {
                        RelayButton(
                            onClick = onStartRun,
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 48.dp),
                            label = stringResource(R.string.home_start_run)
                        )
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = stringResource(R.string.home_recent_runs_title),
                                modifier = Modifier
                                    .weight(1f)
                                    .semantics { heading() },
                                style = MaterialTheme.typography.titleLarge,
                            )

                            TextButton(onClick = onViewHistory) {
                                Text(stringResource(R.string.home_view_history))
                            }
                        }
                    }

                    items(
                        items = uiState.recentRuns,
                        key = { run -> run.id },
                    ) { run ->
                        RecentRunCard(run = run)
                    }
                }
            }
        }
    }
}

@Composable
private fun WeeklyGoalCard(
    distance: String,
    goal: String,
    progress: Float,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {},
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = stringResource(R.string.home_weekly_goal_title),
                style = MaterialTheme.typography.titleMedium,
            )

            Text(
                text = stringResource(R.string.home_weekly_goal_progress, distance, goal),
                style = MaterialTheme.typography.headlineSmall,
            )

            LinearProgressIndicator(
                progress = { progress.coerceIn(0f, 1f) },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun RecentRunCard(
    run: RecentRunUiModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {},
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(
                text = run.title,
                style = MaterialTheme.typography.titleMedium,
            )

            Text(
                text = "${run.distance} · ${run.duration}",
                style = MaterialTheme.typography.bodyLarge,
            )

            Text(
                text = stringResource(R.string.home_recent_run_pace, run.pace),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RunnerHomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            uiState = DummyHomeData.homeUiState,
            onStartRun = {},
            onViewHistory = {},
        )
    }
}