package com.github.wdonahoe.kotlinoverpass.query.builders.statements

class Difference private constructor(
    private val builder: Builder,
    indent: String,
    newline: Boolean
) : Statement(
    indent,
    newline) {

    private val statement1 = builder.statement1
    private val statement2 = builder.statement2

    override fun render(stringBuilder: StringBuilder) =
        run {
            val sb = StringBuilder().apply {
                appendLine("(")
                statement1.indent(builder.indent).newline().build().render(this)
                appendLine("${statement1.indent}-")
                statement2.indent(builder.indent).newline().build().render(this)
                append("${builder.indent});")
            }
            append(
                stringBuilder,
                sb.toString()
            )
        }

    class Builder(
        internal val statement1: Statement.Builder<*>,
        internal val statement2 : Statement.Builder<*>
    ) : Statement.Builder<Difference>() {
        override fun build() = Difference(this, indent, newline)
    }

    companion object {
        fun difference(builder1: Statement.Builder<*>, builder2: Statement.Builder<*>) =
            Builder(builder1, builder2)
    }
}