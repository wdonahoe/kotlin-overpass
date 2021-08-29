package com.github.wdonahoe.kotlinoverpass.query.builders

abstract class Rendered {
    abstract fun render(builder: StringBuilder) : StringBuilder

    override fun toString() = render(StringBuilder()).toString()
}