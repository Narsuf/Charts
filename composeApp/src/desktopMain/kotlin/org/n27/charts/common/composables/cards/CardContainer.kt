package org.n27.charts.common.composables.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.n27.charts.common.fundamentals.color.Palette
import org.n27.charts.common.fundamentals.dimens.CornerRadius

@Composable
fun CardContainer(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val roundedCornerShape = RoundedCornerShape(CornerRadius.smooth)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = roundedCornerShape)
            .background(Color.White, roundedCornerShape)
            .border(
                BorderStroke(1.dp, Palette.Gray),
                roundedCornerShape
            ),
        content = content
    )
}