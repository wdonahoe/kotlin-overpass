package com.github.wdonahoe.kotlinoverpass.query.builders.statements.node

import com.github.wdonahoe.kotlinoverpass.query.models.Filter

object Node {
    fun nodes(raw: String) = NodeRawFilter.Builder(raw)

    fun nodes(vararg ids: Int) = NodeIdFilter.Builder(*ids)

    fun nodes(ids: Collection<Int>) = NodeIdFilter.Builder(ids)

    fun nodes(vararg filters: Filter) = NodeTagFilter.Builder(filters.asList())

    fun nodes(filters: Collection<Filter>) = NodeTagFilter.Builder(filters)
}