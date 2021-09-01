package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.Rendered

abstract class RawFilter(
    private val name: String,
    builder: Builder,
    indent: String,
    newline: Boolean
) : Statement<String>(
    indent,
    newline
) {
    private var value = builder.value

    override fun render(builder: StringBuilder) = append(builder, "$name[$value];")

    abstract class Builder protected constructor(val value: String) : Statement.Builder<RawFilter>()
}