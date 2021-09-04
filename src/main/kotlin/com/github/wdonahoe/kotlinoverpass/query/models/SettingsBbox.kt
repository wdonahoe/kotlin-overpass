package com.github.wdonahoe.kotlinoverpass.query.models

internal class SettingsBbox(
    x1: Double,
    x2: Double,
    y1: Double,
    y2: Double
) : BoundingBox(
    x1,
    x2,
    y1,
    y2
) {
    private constructor() : this(0.0, 0.0, 0.0, 0.0)

    internal constructor(bbox: BoundingBox) : this(bbox.x1, bbox.x2, bbox.y1, bbox.y2)

    override fun render(stringBuilder: StringBuilder) =
        stringBuilder.apply {
            append("[bbox:$x1,$x2,$y1,$y2]")
        }

    companion object {
        val DEFAULT = SettingsBbox()
    }
}