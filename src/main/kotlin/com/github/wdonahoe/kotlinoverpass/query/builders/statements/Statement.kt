package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.Rendered

abstract class Statement<T>(
    indent: String,
    newline: Boolean
) : Rendered(
    indent,
    newline
) {
    abstract class Builder<M : Statement<*>> internal constructor() : Rendered.Builder<M>()
}