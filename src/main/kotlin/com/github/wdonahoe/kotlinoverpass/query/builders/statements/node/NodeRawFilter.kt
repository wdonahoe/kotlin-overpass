package com.github.wdonahoe.kotlinoverpass.query.builders.statements.node

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.RawFilter

class NodeRawFilter(builder: Builder) : RawFilter("node", builder) {

    class Builder(value: String) : RawFilter.Builder(value) {

        override fun build() = NodeRawFilter(this)
    }
}