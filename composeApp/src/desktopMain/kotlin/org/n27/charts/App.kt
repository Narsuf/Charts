package org.n27.charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.n27.charts.common.composables.cards.Card
import org.n27.charts.common.composables.cards.CardContainer
import org.n27.charts.common.composables.charts.PieChart
import org.n27.charts.common.fundamentals.color.Palette.DarkBlue
import org.n27.charts.common.fundamentals.color.Palette.DarkGreen
import org.n27.charts.common.fundamentals.color.Palette.DarkPurple
import org.n27.charts.common.fundamentals.color.Palette.DarkRed
import org.n27.charts.common.fundamentals.color.Palette.DarkYellow
import org.n27.charts.common.fundamentals.color.Palette.LightBlue
import org.n27.charts.common.fundamentals.color.Palette.LightGreen
import org.n27.charts.common.fundamentals.color.Palette.LightPurple
import org.n27.charts.common.fundamentals.color.Palette.LightRed
import org.n27.charts.common.fundamentals.color.Palette.LightYellow
import org.n27.charts.common.fundamentals.dimens.Spacing

@Composable
@Preview
fun App() {
    MaterialTheme {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                PieChart(
                    data = listOf(
                        25f, 5f, 15f,
                        25f, 5f, 5f, 10f,
                        1f, 8f, 1f
                    ),
                    colors = listOf(
                        DarkBlue, DarkRed, DarkGreen,
                        LightBlue, LightRed, LightPurple, LightGreen,
                        LightYellow, DarkYellow, DarkPurple,
                    ),
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(horizontal = Spacing.loose),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                CardContainer {
                    LazyColumn(Modifier.wrapContentHeight()) {
                        itemsIndexed(
                            items = listOf("A", "B"),
                            key = { _, item -> item }
                        ) { index, item ->
                            Card(
                                mainContent = {
                                    Text(item)
                                },
                                endContent = {
                                    Text("30%")
                                },
                                startContent = { Text("1") },
                                includeDivider = index < 2 - 1,
                                onClick = { }
                            )
                        }
                    }
                }
            }
        }
    }
}