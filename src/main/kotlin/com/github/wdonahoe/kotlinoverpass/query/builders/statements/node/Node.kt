package com.github.wdonahoe.kotlinoverpass.query.builders.statements.node

object Node {
    fun nodes(raw: String) = NodeRawFilter.Builder(raw)

    fun nodes(vararg ids: Int) = NodeIdFilter.Builder(*ids)

    fun nodes(ids: Collection<Int>) = NodeIdFilter.Builder(ids)
}