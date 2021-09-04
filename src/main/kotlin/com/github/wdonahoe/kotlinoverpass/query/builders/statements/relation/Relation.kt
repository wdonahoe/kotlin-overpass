package com.github.wdonahoe.kotlinoverpass.query.builders.statements.relation

import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox
import com.github.wdonahoe.kotlinoverpass.query.models.Filter

object Relation {
    fun relations(raw: String) = RawFilter.Builder(raw)

    fun relations(vararg ids: Int) = IdFilter.Builder(*ids)

    fun relations(ids: Collection<Int>) = IdFilter.Builder(ids)

    fun relations(vararg filters: Filter) = TagFilter.Builder(filters.asList())

    fun relations(filters: Collection<Filter>) = TagFilter.Builder(filters)

    fun relations(bbox: BoundingBox) = BboxFilter.Builder(bbox)
}