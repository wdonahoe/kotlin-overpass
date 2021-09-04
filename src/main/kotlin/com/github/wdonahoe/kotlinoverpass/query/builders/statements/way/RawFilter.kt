package com.github.wdonahoe.kotlinoverpass.query.builders.statements.way

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.RawFilter

class RawFilter(
    builder: Builder,
    indent: String,
    newline: Boolean
) : RawFilter(
    "way",
    builder,
    indent,
    newline
) {

    class Builder(value: String) : RawFilter.Builder(value) {

        override fun build() =
            RawFilter(this, indent, newline)
    }
}