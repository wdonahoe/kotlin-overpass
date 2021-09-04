package com.github.wdonahoe.kotlinoverpass.query.builders.statements.node

import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox
import com.github.wdonahoe.kotlinoverpass.query.models.Filter

object Node {
    fun nodes(raw: String) = RawFilter.Builder(raw)

    fun nodes(vararg ids: Int) = IdFilter.Builder(*ids)

    fun nodes(ids: Collection<Int>) = IdFilter.Builder(ids)

    fun nodes(filters: Collection<Filter>) = TagFilter.Builder(filters)

    fun nodes(vararg filters: Filter) = TagFilter.Builder(filters.asList())

    fun nodes(bbox: BoundingBox) = BboxFilter.Builder(bbox)
}