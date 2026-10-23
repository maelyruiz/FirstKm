package com.maeruiz.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.maeruiz.designsystem.theme.RelayTheme

@Composable
fun RelayButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    val colors = RelayTheme.colors

    Button(
       onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.primary,
            contentColor = colors.onPrimary
        ),
        border = BorderStroke(
            width = 2.dp,
            color = colors.secondary
        ),
        contentPadding = PaddingValues(
            horizontal = 24.dp,
            vertical = 16.dp
        )
    ){
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}