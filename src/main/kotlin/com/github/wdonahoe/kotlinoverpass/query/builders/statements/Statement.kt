package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.Rendered
import com.github.wdonahoe.kotlinoverpass.query.models.ToNamedSet

abstract class Statement(
    indent: String,
    newline: Boolean,
    protected val namedSet: ToNamedSet? = null
) : Rendered(
    indent,
    newline
) {
    protected fun renderToSet() = namedSet?.toString() ?: ""

    abstract class Builder<M : Statement> internal constructor() : Rendered.Builder<M>() {
        var namedSet: ToNamedSet? = null

        open fun toSet(setName: String) =
            apply {
                namedSet = ToNamedSet(setName)
            }
    }
}