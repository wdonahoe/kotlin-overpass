package com.github.wdonahoe.kotlinoverpass.query.builders.statements.node

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.IdFilter

class NodeIdFilter(builder: Builder) : IdFilter("node", builder) {

    class Builder(vararg ids: Int) : IdFilter.Builder(ids) {

        constructor(ids: Collection<Int>) : this(*ids.toIntArray())

        override fun build() = NodeIdFilter(this)
    }
}