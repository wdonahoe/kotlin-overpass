package com.github.wdonahoe.kotlinoverpass.query.builders.statements

import com.github.wdonahoe.kotlinoverpass.query.Rendered
import com.github.wdonahoe.kotlinoverpass.query.builders.RenderedBuilder

abstract class QueryStatement<T>(
    protected val name: String
) : Rendered() {
    abstract class Builder<M : QueryStatement<*>> internal constructor() : RenderedBuilder<M>()
}