package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.Rendered
import com.github.wdonahoe.kotlinoverpass.query.annotations.OverpassMarker

class Overpass private constructor(private val builder: Builder) : Rendered() {
    private val settings get() = builder.settings.build()

    private val url = builder.url

    override fun render(builder: StringBuilder) =
        builder.apply {
            settings.render(builder)
        }

    @OverpassMarker
    class Builder internal constructor() {
        internal var settings = Settings.Builder()

        internal var url = DEFAULT_INSTANCE

        fun url(url: String) = apply {
            this.url = url
        }

        fun settings(init: (Settings.Builder.() -> Unit)? = null) : Settings.Builder {
            this.settings = Settings.Builder.init(init ?: { })
            return settings
        }

        fun settings(builder: Settings.Builder) : Settings.Builder {
            this.settings = builder
            return settings
        }

        fun build() = Overpass(this)
    }

    companion object {
        const val MAIN_INSTANCE = "https://lz4.overpass-api.de/api/interpreter"
        const val DEFAULT_INSTANCE = MAIN_INSTANCE

        fun overpass(init: (Builder.() -> Unit)? = null) = Builder().apply(init ?: { })
    }
}