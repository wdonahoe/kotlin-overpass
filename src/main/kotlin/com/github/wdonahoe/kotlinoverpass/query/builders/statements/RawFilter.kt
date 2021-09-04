package com.github.wdonahoe.kotlinoverpass.query.builders.statements

abstract class RawFilter(
    private val name: String,
    builder: Builder,
    indent: String,
    newline: Boolean
) : Statement(
    indent,
    newline
) {
    private var value = builder.value

    override fun render(stringBuilder: StringBuilder) = append(stringBuilder, "$name[$value]$;")

    abstract class Builder protected constructor(val value: String) : Statement.Builder<RawFilter>()
}