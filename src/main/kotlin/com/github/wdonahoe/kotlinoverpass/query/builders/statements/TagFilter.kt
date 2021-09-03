package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.models.Filter

abstract class TagFilter(
    private val name: String,
    builder: Builder,
    indent: String,
    newline: Boolean
) : Statement(
    indent,
    newline
) {
    private val filters = builder.filters

    override fun render(stringBuilder: StringBuilder) =
        append(
            stringBuilder,
            StringBuilder().apply {
                append(name)
                for (filter in filters) {
                    append(filter.toString())
                }
                append(";")
            }.toString()
        )

    abstract class Builder protected constructor(val filters: Collection<Filter>) : Statement.Builder<TagFilter>()
}