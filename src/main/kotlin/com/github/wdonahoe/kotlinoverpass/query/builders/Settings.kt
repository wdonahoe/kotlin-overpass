package com.github.wdonahoe.kotlinoverpass.query.builders

import org.locationtech.jts.geom.Envelope
import org.locationtech.jts.geom.Geometry

class Settings private constructor() : Element() {
    private var boundingBox = BoundingBox.DEFAULT
    private var timeout = Timeout.DEFAULT

    override val children: Sequence<Rendered>
        get() =
            sequence {
                if (boundingBox != BoundingBox.DEFAULT) yield(boundingBox)
                if (timeout != Timeout.DEFAULT) yield(timeout)
            }

    override fun render(builder: StringBuilder) =
        builder.apply {
            for (child in children) {
                child.render(builder)
            }

            append(";")
        }


    fun bbox(envelope: Envelope) =
        BoundingBox(envelope).apply {
            boundingBox = this
        }

    fun bbox(geometry: Geometry) =
        BoundingBox(geometry).apply {
            boundingBox = this
        }

    fun bbox(x1: Double, x2: Double, y1: Double, y2: Double) =
        BoundingBox(x1, x2, y1, y2).apply {
            boundingBox = this
        }

    fun timeout(seconds: Int) =
        Timeout(seconds).apply {
            timeout = this
        }

    companion object {
        fun init(init: Initializer<Settings> = null) = Settings().apply(init ?: { })
    }
}