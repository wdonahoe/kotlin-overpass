package com.github.wdonahoe.kotlinoverpass.query.models

import com.github.wdonahoe.kotlinoverpass.query.Rendered

class Timeout(private val seconds: Int = 180) : Rendered() {

    override fun render(builder: StringBuilder) =
        builder.apply {
            append("[timeout:$seconds]")
        }

    companion object {
        val DEFAULT = Timeout()
    }
}