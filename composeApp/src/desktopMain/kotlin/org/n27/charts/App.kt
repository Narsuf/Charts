package org.n27.charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
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
import org.n27.charts.domain.Asset

@Composable
@Preview
fun App() {

    val assets = persistentListOf(
        Asset(name = "USD bond 7-10yr", color = DarkBlue, percentage = 25f),
        Asset(name = "German bonds", color = DarkRed, percentage = 5f),
        Asset(name = "Other bonds", color = DarkGreen, percentage = 15f),

        Asset(name = "S&P 500", color = LightBlue, percentage = 25f),
        Asset(name = "DAX 40", color = LightRed, percentage = 5f),
        Asset(name = "NIKKEI 225", color = LightPurple, percentage = 5f),
        Asset(name = "Stocks", color = LightGreen, percentage = 10f),

        Asset(name = "Bitcoin", color = LightYellow, percentage = 1f),
        Asset(name = "Gold", color = DarkYellow, percentage = 8f),
        Asset(name = "Commodity", color = DarkPurple, percentage = 1f),
    )

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
                    data = assets.map { it.percentage }.toPersistentList(),
                    colors = assets.map { Color(it.color) }.toPersistentList(),
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