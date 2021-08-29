package com.github.wdonahoe.kotlinoverpass.query.builders

class Timeout(val seconds: Int = 180) : Rendered() {

    override fun render(builder: StringBuilder) =
        builder.apply {
            append("[timeout:$seconds]")
        }

    companion object {
        val DEFAULT = Timeout()
    }
}