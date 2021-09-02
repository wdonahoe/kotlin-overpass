package com.github.wdonahoe.kotlinoverpass.query

import com.github.wdonahoe.kotlinoverpass.query.extensions.appendNewlineIf

abstract class Rendered(
    private val indent: String = "",
    private val newline: Boolean = false
) {
    abstract fun render(stringBuilder: StringBuilder) : StringBuilder

    open fun append(stringBuilder: StringBuilder, text: String) = stringBuilder.appendNewlineIf("$indent$text", newline)

    override fun toString() = render(StringBuilder()).toString()

    abstract class Builder<T : Rendered> {

        internal var indent = ""
        internal var newline = false

        fun indent(str: String = "") =
            apply {
                indent += "$str    "
            }

        fun newline() =
            apply {
                newline = true
            }

        abstract fun build() : T
    }
}