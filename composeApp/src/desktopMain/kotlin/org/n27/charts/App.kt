package org.n27.charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.n27.charts.common.composables.PieChart
import org.n27.charts.common.fundamentals.Palette
import org.n27.charts.common.fundamentals.Palette.DarkBlue
import org.n27.charts.common.fundamentals.Palette.DarkGreen
import org.n27.charts.common.fundamentals.Palette.DarkPurple
import org.n27.charts.common.fundamentals.Palette.DarkRed
import org.n27.charts.common.fundamentals.Palette.DarkYellow
import org.n27.charts.common.fundamentals.Palette.LightBlue
import org.n27.charts.common.fundamentals.Palette.LightGreen
import org.n27.charts.common.fundamentals.Palette.LightPurple
import org.n27.charts.common.fundamentals.Palette.LightRed
import org.n27.charts.common.fundamentals.Palette.LightYellow

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            PieChart(
                data = listOf(
                    25f, 5f, 15f,
                    25f, 5f, 5f, 10f,
                    8f, 1f, 1f
                ),
                colors = listOf(
                    DarkBlue, DarkRed, DarkGreen,
                    LightBlue, LightRed, LightPurple, LightGreen,
                    DarkYellow, LightYellow, DarkPurple,
                ),
            )
        }
    }
}