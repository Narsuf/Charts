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
import org.n27.charts.common.fundamentals.color.Palette.BLUE
import org.n27.charts.common.fundamentals.color.Palette.DARK_BLUE
import org.n27.charts.common.fundamentals.color.Palette.DARK_GREEN
import org.n27.charts.common.fundamentals.color.Palette.DARK_PURPLE
import org.n27.charts.common.fundamentals.color.Palette.DARK_RED
import org.n27.charts.common.fundamentals.color.Palette.DARK_YELLOW
import org.n27.charts.common.fundamentals.color.Palette.GREEN
import org.n27.charts.common.fundamentals.color.Palette.LIGHT_BLUE
import org.n27.charts.common.fundamentals.color.Palette.RED
import org.n27.charts.common.fundamentals.color.Palette.YELLOW
import org.n27.charts.common.fundamentals.dimens.Spacing
import org.n27.charts.domain.Asset

private val assets = persistentListOf(
    Asset(name = "USD bond 20+yr", color = DARK_BLUE, percentage = 14f),
    Asset(name = "USD bond 7-10yr", color = BLUE, percentage = 14f),
    Asset(name = "EUR bond 7-10yr", color = DARK_GREEN, percentage = 14f),

    Asset(name = "Stocks", color = DARK_RED, percentage = 2f),

    Asset(name = "S&P (1)500", color = LIGHT_BLUE, percentage = 21f),
    Asset(name = "STOXX 600", color = GREEN, percentage = 16f),
    Asset(name = "TOPIX", color = RED, percentage = 3f),

    Asset(name = "Bitcoin", color = YELLOW, percentage = 1f),
    Asset(name = "Gold", color = DARK_YELLOW, percentage = 14f),
    Asset(name = "Commodity", color = DARK_PURPLE, percentage = 1f),
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
