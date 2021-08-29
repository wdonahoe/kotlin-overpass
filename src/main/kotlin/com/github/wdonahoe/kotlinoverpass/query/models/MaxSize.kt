package com.github.wdonahoe.kotlinoverpass.query.models

import com.github.wdonahoe.kotlinoverpass.query.Rendered


class MaxSize(private val size: Int = 536870912) : Rendered() {

    override fun render(builder: StringBuilder) =
        builder.apply {
            append("[maxsize:$size]")
        }

    companion object {
        val DEFAULT = MaxSize()
    }
}