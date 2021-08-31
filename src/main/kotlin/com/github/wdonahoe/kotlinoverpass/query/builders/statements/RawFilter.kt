package com.github.wdonahoe.kotlinoverpass.query.builders.statements

abstract class RawFilter(name: String, builder: Builder) : QueryStatement<String>(name) {

    private var value = builder.value

    override fun render(builder: StringBuilder) =
        builder.apply {
            append("$name[$value];")
        }

    abstract class Builder protected constructor(val value: String) : QueryStatement.Builder<RawFilter>()
}