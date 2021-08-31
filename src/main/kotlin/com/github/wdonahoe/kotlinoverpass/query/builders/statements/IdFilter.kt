package com.github.wdonahoe.kotlinoverpass.query.builders.statements

abstract class IdFilter(name: String, builder: Builder) : QueryStatement<Int>(name) {

    private val ids: IntArray = builder.ids

    override fun render(builder: StringBuilder) =
        builder.apply {
            if (ids.size == 1) append("$name(${ids[0]})") else append("$name(id:$ids)")
        }

    abstract class Builder protected constructor(val ids: IntArray) : QueryStatement.Builder<IdFilter>()
}