package com.github.wdonahoe.kotlinoverpass.query.builders.statements.way

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.BboxFilter
import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox

class BboxFilter(
    builder: Builder,
    indent: String,
    newline: Boolean
) : BboxFilter(
    "way",
    builder,
    indent,
    newline
) {
    class Builder(bbox: BoundingBox) : BboxFilter.Builder(bbox) {
        override fun build() =
            BboxFilter(this, indent, newline)
    }
}