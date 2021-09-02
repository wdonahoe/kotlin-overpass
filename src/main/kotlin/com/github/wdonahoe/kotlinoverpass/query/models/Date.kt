package com.github.wdonahoe.kotlinoverpass.query.models

import com.github.wdonahoe.kotlinoverpass.query.Rendered
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class Date(private val date: OffsetDateTime) : Rendered() {

    constructor(date: String) : this(OffsetDateTime.parse(date))

    private val formatted
        get() =
            date.atZoneSameInstant(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern(PATTERN))

    override fun render(stringBuilder: StringBuilder) =
        stringBuilder.apply {
            append("[date:$formatted]")
        }

    companion object {
        val DEFAULT = Date(OffsetDateTime.now())
        private val PATTERN = "yyyy-MM-dd'T'hh:mm:ss'Z'"
    }
}