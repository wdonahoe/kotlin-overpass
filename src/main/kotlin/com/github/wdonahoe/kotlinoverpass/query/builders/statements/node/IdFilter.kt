package com.github.wdonahoe.kotlinoverpass.query.builders.statements.node

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.IdFilter

class IdFilter(
    builder: Builder,
    indent: String,
    newline: Boolean
) : IdFilter(
    "node",
    builder,
    indent,
    newline
) {

    class Builder(vararg ids: Int) : IdFilter.Builder(ids) {

        constructor(ids: Collection<Int>) : this(*ids.toIntArray())

        override fun build() =
            IdFilter(this, indent, newline)
    }
}