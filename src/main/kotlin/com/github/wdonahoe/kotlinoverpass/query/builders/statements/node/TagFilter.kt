package com.github.wdonahoe.kotlinoverpass.query.builders.statements.node

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.TagFilter
import com.github.wdonahoe.kotlinoverpass.query.models.Filter

class TagFilter(
    builder: Builder,
    indent: String,
    newline: Boolean
) : TagFilter(
    "node",
    builder,
    indent,
    newline
) {
    class Builder(filters: Collection<Filter>) : TagFilter.Builder(filters) {
        override fun build() =
            TagFilter(this, indent, newline)
    }
}