package com.github.wdonahoe.kotlinoverpass.query.builders.statements.way

import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox
import com.github.wdonahoe.kotlinoverpass.query.models.Filter

object Way {
    fun ways(raw: String) = RawFilter.Builder(raw)

    fun ways(vararg ids: Int) = IdFilter.Builder(*ids)

    fun ways(ids: Collection<Int>) = IdFilter.Builder(ids)

    fun ways(vararg filters: Filter) = TagFilter.Builder(filters.asList())

    fun ways(filters: Collection<Filter>) = TagFilter.Builder(filters)

    fun ways(bbox: BoundingBox) = BboxFilter.Builder(bbox)
}