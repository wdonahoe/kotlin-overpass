package com.github.wdonahoe.kotlinoverpass.query.builders

import org.locationtech.jts.geom.Envelope
import org.locationtech.jts.geom.Geometry

class BoundingBox(private val envelope: Envelope) : Rendered() {

    constructor(geometry: Geometry) : this(geometry.envelopeInternal)

    constructor(x1: Double, x2: Double, y1: Double, y2: Double) : this(Envelope(x1, x2, y1, y2))

    private constructor() : this(Envelope())

    override fun render(builder: StringBuilder) =
        builder.apply {
            append("[bbox:${envelope.minX},${envelope.maxX},${envelope.minY},${envelope.maxY}]")
        }

    companion object {
        val DEFAULT = BoundingBox()
    }
}