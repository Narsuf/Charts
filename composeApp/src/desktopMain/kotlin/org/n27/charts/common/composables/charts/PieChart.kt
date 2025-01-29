package org.n27.charts.common.composables.charts

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlinx.collections.immutable.ImmutableList

@Composable
fun PieChart(
    data: ImmutableList<Float>,
    colors: ImmutableList<Color>,
    thicknessRatio: Float = 0.2f,
) {
    val total = data.sum()
    if (total == 0f) return

    Canvas(
        modifier = Modifier
            .fillMaxSize(0.70f)
            .aspectRatio(1f)
    ) {
        var startAngle = 0f
        val minSize = minOf(size.width, size.height)
        val thickness = minSize * thicknessRatio

        data.forEachIndexed { index, value ->
            val sweepAngle = (value / total) * 360f

            drawPieSlice(
                color = colors.getOrElse(index) { Color.Gray },
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                size = size,
                thickness = thickness
            )

            startAngle += sweepAngle
        }
    }
}

private fun DrawScope.drawPieSlice(
    color: Color,
    startAngle: Float,
    sweepAngle: Float,
    size: Size,
    thickness: Float
) {
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(width = thickness),
        size = size
    )
}
