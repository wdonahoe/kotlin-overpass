package com.github.wdonahoe.kotlinoverpass.query.builders

import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

class Date(private val date: OffsetDateTime) : Rendered() {

    constructor(date: String) : this(OffsetDateTime.parse(date))

    private val formatted
        get() =
            date.atZoneSameInstant(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss'Z'"))

    override fun render(builder: StringBuilder) =
        builder.apply {
            append("[date:$formatted]")
        }

    companion object {
        val DEFAULT = Date(OffsetDateTime.now())
    }
}