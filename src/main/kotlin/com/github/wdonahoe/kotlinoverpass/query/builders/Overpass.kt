package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.annotations.OverpassMarker

class Overpass private constructor(builder: Builder) : BaseUnion(builder, "", false) {
    private val settings = builder.settingsBuilder

    override fun render(stringBuilder: StringBuilder) =
        stringBuilder.apply {
            settings.build().render(stringBuilder)

            if (stringBuilder.isNotEmpty() && childBuilders.isNotEmpty()) {
                appendLine()
            }

            for (child in childBuilders.withIndex()) {
                if (child.index < childBuilders.size - 1) {
                    child.value.newline()
                }

                child.value.build().render(stringBuilder)
            }
        }

    @OverpassMarker
    class Builder internal constructor() : BaseUnion.Builder<Overpass>() {
        internal var settingsBuilder = Settings.Builder.init { }

        fun settings(init: (Settings.Builder.() -> Unit)) =
            run {
                settingsBuilder = Settings.Builder.init(init)
                settingsBuilder
            }

        fun settings(builder: Settings.Builder) =
            apply {
                settingsBuilder = builder
            }

        override fun build() = Overpass(this)
    }

    companion object {
        fun overpass(init: (Builder.() -> Unit)? = null) = Builder().apply(init ?: { })
    }
}