package com.github.wdonahoe.kotlinoverpass.query.builders.statements

abstract class IdFilter(
    private val name: String,
    builder: Builder,
    indent: String,
    newline: Boolean
) : Statement(
    indent,
    newline
) {
    private val ids: IntArray = builder.ids

    override fun render(stringBuilder: StringBuilder) =
        if (ids.size == 1) {
            append(stringBuilder, "$name(${ids[0]});")
        } else {
            append(stringBuilder, "$name(id:${ids.joinToString(",")});")
        }

    abstract class Builder protected constructor(val ids: IntArray) : Statement.Builder<IdFilter>()
}