package com.github.wdonahoe.kotlinoverpass.query.models

import com.github.wdonahoe.kotlinoverpass.query.Rendered

open class BoundingBox(
    val x1: Double,
    val x2: Double,
    val y1: Double,
    val y2: Double
) : Rendered() {
    override fun render(stringBuilder: StringBuilder) =
        stringBuilder.apply {
            append("$x1,$x2,$y1,$y2")
        }
}