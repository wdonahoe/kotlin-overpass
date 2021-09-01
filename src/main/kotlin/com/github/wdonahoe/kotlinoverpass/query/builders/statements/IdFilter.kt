package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.Rendered

abstract class IdFilter(
    private val name: String,
    builder: Builder,
    indent: String,
    newline: Boolean
) : Statement<Int>(
    indent,
    newline
) {
    private val ids: IntArray = builder.ids

    override fun render(builder: StringBuilder) =
        if (ids.size == 1) {
            append(builder, "$name(${ids[0]});")
        } else {
            append(builder, "$name(id:${ids.joinToString(",")});")
        }

    abstract class Builder protected constructor(val ids: IntArray) : Statement.Builder<IdFilter>()
}