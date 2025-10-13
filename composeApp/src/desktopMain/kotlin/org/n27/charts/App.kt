package org.n27.charts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.n27.charts.common.composables.cards.Card
import org.n27.charts.common.composables.cards.CardContainer
import org.n27.charts.common.composables.charts.PieChart
import org.n27.charts.common.fundamentals.color.Palette.DARK_BLUE
import org.n27.charts.common.fundamentals.color.Palette.DARK_GREEN
import org.n27.charts.common.fundamentals.color.Palette.DARK_YELLOW
import org.n27.charts.common.fundamentals.color.Palette.LIGHT_BLUE
import org.n27.charts.common.fundamentals.color.Palette.LIGHT_GREEN
import org.n27.charts.common.fundamentals.color.Palette.LIGHT_RED
import org.n27.charts.common.fundamentals.color.Palette.LIGHT_YELLOW
import org.n27.charts.common.fundamentals.dimens.Spacing
import org.n27.charts.domain.Asset

/*
World GDP percentage:
US -> ≈26.8%
Germany -> ≈4.2%
Japan -> ≈3.7%
*/

private val assets = persistentListOf(
    Asset(name = "Dollar Treasury Bond 7-10yr", color = DARK_BLUE, percentage = 15f),
    Asset(name = "Cash", color = DARK_GREEN, percentage = 25f),
    Asset(name = "Gold", color = DARK_YELLOW, percentage = 15f),

    Asset(name = "Stocks", color = LIGHT_BLUE, percentage = 30f),

    // 15%
    Asset(name = "S&P 500", color = LIGHT_GREEN, percentage = 11.58f),
    Asset(name = "DAX", color = LIGHT_YELLOW, percentage = 1.82f),
    Asset(name = "NIKKEI", color = LIGHT_RED, percentage = 1.6f),
)

@Composable
@Preview
fun App() {
    MaterialTheme {
        Row(verticalAlignment = Alignment.CenterVertically) {
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
                    .padding(Spacing.loose),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CardContainer {
                    LazyColumn {
                        itemsIndexed(assets) { index, item ->
                            Card(
                                startContent = {
                                    Box(
                                        modifier = Modifier
                                            .size(16.dp)
                                            .background(Color(item.color))
                                    )
                                },
                                mainContent = { Text(item.name) },
                                endContent = {
                                    Text(
                                        text = "${item.percentage.toBigDecimal()
                                            .setScale(2)
                                            .stripTrailingZeros()
                                            .toPlainString()}%"
                                    )
                                },
                                includeDivider = index < assets.size - 1,
                            )
                        }
                    }
                }
            }
        }
    }
}
