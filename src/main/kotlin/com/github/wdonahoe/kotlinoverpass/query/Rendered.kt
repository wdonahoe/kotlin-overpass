package com.github.wdonahoe.kotlinoverpass.query

abstract class Rendered {
    abstract fun render(builder: StringBuilder) : StringBuilder

    override fun toString() = render(StringBuilder()).toString()
}