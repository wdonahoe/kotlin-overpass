package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.Rendered
import com.github.wdonahoe.kotlinoverpass.query.annotations.OverpassMarker
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.NodeIdFilter
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.NodeRawFilter

class Overpass private constructor(private val builder: Builder) : Rendered() {
    private val settings get() = builder.settings.build()

    private val children get() = builder.children.map { it.build() }

    private val url = builder.url

    override fun render(builder: StringBuilder) =
        builder.apply {
            settings.render(builder)
            for (child in children) {
                child.render(builder)
            }
        }

    @OverpassMarker
    class Builder internal constructor() {
        internal var settings = Settings.Builder.init { }

        internal val children = mutableListOf<RenderedBuilder<*>>()

        internal var url = DEFAULT_INSTANCE

        fun url(url: String) =
            apply {
                this.url = url
            }

        fun settings(init: (Settings.Builder.() -> Unit)) =
            run {
                settings = Settings.Builder.init(init)
                settings
            }

        fun settings(builder: Settings.Builder) =
            apply {
                settings = builder
            }

        fun nodes(raw: String) =
            apply {
                NodeRawFilter.Builder(raw).let { builder ->
                    children.add(builder)
                }
            }

        fun nodes(vararg ids: Int) =
            apply {
                NodeIdFilter.Builder(*ids).let { builder ->
                    children.add(builder)
                }
            }

        fun nodes(ids: Collection<Int>) =
            apply {
                NodeIdFilter.Builder(ids).let { builder ->
                    children.add(builder)
                }
            }

        fun build() = Overpass(this)
    }

    companion object {
        const val MAIN_INSTANCE = "https://lz4.overpass-api.de/api/interpreter"
        const val DEFAULT_INSTANCE = MAIN_INSTANCE

        fun overpass(init: (Builder.() -> Unit)? = null) = Builder().apply(init ?: { })
    }
}