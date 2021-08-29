package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.Rendered
import com.github.wdonahoe.kotlinoverpass.query.annotations.OverpassMarker
import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox
import com.github.wdonahoe.kotlinoverpass.query.models.Date
import com.github.wdonahoe.kotlinoverpass.query.models.MaxSize
import com.github.wdonahoe.kotlinoverpass.query.models.Timeout
import java.time.OffsetDateTime

class Settings private constructor(builder: Builder) : Rendered() {

    private var boundingBox = builder.boundingBox
    private var timeout = builder.timeout
    private var date = builder.date
    private var maxsize = builder.maxsize

    override fun render(builder: StringBuilder) =
        builder.apply {
            if (boundingBox != BoundingBox.DEFAULT) boundingBox.render(builder)
            if (timeout != Timeout.DEFAULT) timeout.render(builder)
            if (date != Date.DEFAULT) date.render(builder)
            if (maxsize != MaxSize.DEFAULT) maxsize.render(builder)

            append(";")
        }

    @OverpassMarker
    class Builder internal constructor() {
        internal var boundingBox = BoundingBox.DEFAULT
        internal var timeout = Timeout.DEFAULT
        internal var date = Date.DEFAULT
        internal var maxsize = MaxSize.DEFAULT

        fun bbox(x1: Double, x2: Double, y1: Double, y2: Double) =
            BoundingBox(x1, x2, y1, y2).apply {
                boundingBox = this
            }

        fun timeout(seconds: Int) =
            Timeout(seconds).apply {
                timeout = this
            }

        fun maxsize(size: Int) =
            MaxSize(size).apply {
                maxsize = this
            }

        fun date(dateTime: OffsetDateTime) =
            Date(dateTime).apply {
                date = this
            }

        fun date(dateTime: String) =
            Date(dateTime).apply {
                date = this
            }

        fun build() = Settings(this)

        companion object {
            internal fun init(init: (Builder.() -> Unit)? = null) = Builder().apply(init ?: { })
        }
    }
}