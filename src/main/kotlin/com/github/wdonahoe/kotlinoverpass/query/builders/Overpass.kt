package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.Rendered
import com.github.wdonahoe.kotlinoverpass.query.annotations.OverpassMarker
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.Union
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.NodeIdFilter
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.NodeRawFilter

class Overpass private constructor(private val builder: Builder) : Rendered() {
    private val settings get() = builder.settingsBuilder
    private val children get() = builder.childBuilders
    private val url get() = builder.url

    override fun render(builder: StringBuilder) =
        builder.apply {
            settings.build().render(builder)

            if (builder.isNotEmpty() && children.isNotEmpty()) {
                appendLine()
            }

            for (child in children.withIndex()) {
                if (child.index < children.size - 1) {
                    child.value.newline()
                }

                child.value.build().render(builder)
            }
        }

    @OverpassMarker
    class Builder internal constructor() {
        internal var settingsBuilder = Settings.Builder.init { }

        internal val childBuilders = mutableListOf<Rendered.Builder<*>>()

        internal var url = DEFAULT_INSTANCE

        fun url(url: String) =
            apply {
                this.url = url
            }

        fun settings(init: (Settings.Builder.() -> Unit)) =
            run {
                settingsBuilder = Settings.Builder.init(init)
                settingsBuilder
            }

        fun settings(builder: Settings.Builder) =
            apply {
                settingsBuilder = builder
            }

        fun nodes(raw: String) =
            apply {
                NodeRawFilter.Builder(raw).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun nodes(vararg ids: Int) =
            apply {
                NodeIdFilter.Builder(*ids).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun nodes(ids: Collection<Int>) =
            apply {
                NodeIdFilter.Builder(ids).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun union(init: (Union.Builder.() -> Unit)) =
            run {
                val builder = Union.Builder().apply(init)
                childBuilders.add(builder)
                builder
            }

        fun build() = Overpass(this)
    }

    companion object {
        const val MAIN_INSTANCE = "https://lz4.overpass-api.de/api/interpreter"
        const val DEFAULT_INSTANCE = MAIN_INSTANCE

        fun overpass(init: (Builder.() -> Unit)? = null) = Builder().apply(init ?: { })
    }
}