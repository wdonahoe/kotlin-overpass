package com.github.wdonahoe.kotlinoverpass.query.models

import com.github.wdonahoe.kotlinoverpass.query.Rendered

class BoundingBox(
    private val x1: Double,
    private val x2: Double,
    private val y1: Double,
    private val y2: Double
) : Rendered() {

    private constructor() : this(0.0, 0.0, 0.0, 0.0)

    override fun render(stringBuilder: StringBuilder) =
        stringBuilder.apply {
            append("[bbox:$x1,$x2,$y1,$y2]")
        }

    companion object {
        val DEFAULT = BoundingBox()
    }
}