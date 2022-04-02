package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.builders.BaseUnion

class Union(
    builder: Builder,
    indent: String,
    newline: Boolean
) : BaseUnion(
    builder,
    indent,
    newline
) {
    override fun render(stringBuilder: StringBuilder) =
        run {
            val sb = StringBuilder().apply {
                appendLine("(")
                for (statement in childBuilders) {
                    statement.indent(builder.indent).newline().build().render(this)
                }
                append("${builder.indent})${renderToSet()};")
            }
            append(
                stringBuilder,
                sb.toString()
            )
        }

    class Builder : BaseUnion.Builder<Union>() {
        override fun build() = Union(this, indent, newline)
    }

    companion object {
        fun union(init: (Builder.() -> Unit)) = Builder().apply(init)
    }
}