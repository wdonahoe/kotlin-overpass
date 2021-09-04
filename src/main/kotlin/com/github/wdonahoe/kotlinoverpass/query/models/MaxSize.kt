package com.github.wdonahoe.kotlinoverpass.query.models

import com.github.wdonahoe.kotlinoverpass.query.Rendered

data class MaxSize(private val size: Int = 536870912) : Rendered() {

    override fun render(stringBuilder: StringBuilder) =
        stringBuilder.apply {
            append("[maxsize:$size]")
        }

    companion object {
        val DEFAULT = MaxSize()
    }
}