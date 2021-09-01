package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.Rendered
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.NodeIdFilter
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.NodeRawFilter

class Union(
    private val builder: Builder,
    indent: String,
    newline: Boolean
) : Statement<Statement<*>>(
    indent,
    newline
) {
    private val childBuilders = builder.childBuilders

    override fun render(builder: StringBuilder) =
        run {
            val sb = StringBuilder().apply {
                appendLine("(")
                for (statement in childBuilders) {
                    statement.indent(this@Union.builder.indent).newline().build().render(this)
                }
                append("${this@Union.builder.indent});")
            }
                append(
                    builder,
                    sb.toString()
                )
            }

    class Builder : Statement.Builder<Union>() {

        internal val childBuilders = mutableListOf<Statement.Builder<*>>()

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

        fun union(init: (Builder.() -> Unit)) =
            run {
                val builder = Builder().apply(init)
                childBuilders.add(builder)
                builder
            }

        override fun build() = Union(this, indent, newline)
    }
}