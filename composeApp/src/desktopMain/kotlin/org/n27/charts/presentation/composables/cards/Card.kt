package org.n27.charts.presentation.composables.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.n27.charts.presentation.fundamentals.dimens.Spacing

private val StartImageSize = 48.dp
private val CardMinHeight = 72.dp

@Composable
fun Card(
    start: @Composable () -> Unit,
    center: @Composable () -> Unit,
    end: @Composable () -> Unit,
    includeDivider: Boolean = false
) {
    Box(
        modifier = Modifier
            .defaultMinSize(minHeight = CardMinHeight)
            .padding(
                horizontal = Spacing.default,
                vertical = Spacing.small,
            )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            Box(
                Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = Spacing.default)
                    .size(StartImageSize),
                contentAlignment = Alignment.Center
            ) { start() }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) { center() }

            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = Spacing.default)
            ) { end() }
        }
    }

    if (includeDivider) { Divider() }
}
