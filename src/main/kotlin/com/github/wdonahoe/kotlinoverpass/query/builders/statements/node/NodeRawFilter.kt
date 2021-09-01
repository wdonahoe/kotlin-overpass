package com.github.wdonahoe.kotlinoverpass.query.builders.statements.node

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.RawFilter

class NodeRawFilter(
    builder: Builder,
    indent: String,
    newline: Boolean
) : RawFilter(
    "node",
    builder,
    indent,
    newline
) {

    class Builder(value: String) : RawFilter.Builder(value) {

        override fun build() = NodeRawFilter(this, indent, newline)
    }
}