package com.github.wdonahoe.kotlinoverpass.query.builders

class Overpass private constructor(private val url: String) : Rendered() {
    private var settings: Settings = settings()

    fun settings(initializer: Initializer<Settings> = null) =
        Settings.init(initializer).apply {
            settings = this
        }

    override fun render(builder: StringBuilder) =
        builder.apply {
            settings.render(builder)
        }

    companion object {
        const val MAIN_INSTANCE = "https://lz4.overpass-api.de/api/interpreter"
        const val DEFAULT_INSTANCE = MAIN_INSTANCE

        fun overpass(url: String = DEFAULT_INSTANCE, init: Overpass.() -> Unit) = Overpass(url).apply(init)
    }
}