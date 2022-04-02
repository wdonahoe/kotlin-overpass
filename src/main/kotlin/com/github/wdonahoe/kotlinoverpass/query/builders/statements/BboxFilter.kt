package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox

abstract class BboxFilter(
    private val name: String,
    builder: Builder,
    indent: String,
    newline: Boolean
) : Statement(
    indent,
    newline,
    builder.namedSet
) {
    private var bbox = builder.bbox

    override fun render(stringBuilder: StringBuilder) = append(stringBuilder, "$name(${bbox.x1},${bbox.x2},${bbox.y1},${bbox.y2})${renderToSet()};")

    abstract class Builder protected constructor(val bbox: BoundingBox) : Statement.Builder<BboxFilter>()
}