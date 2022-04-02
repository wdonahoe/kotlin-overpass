package com.github.wdonahoe.kotlinoverpass.query.models

class ToNamedSet(setName: String) {
    private val namedSet = NamedSet(setName)

    override fun toString() =
        "->$namedSet"
}