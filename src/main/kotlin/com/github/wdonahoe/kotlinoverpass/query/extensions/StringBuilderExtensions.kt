package com.github.wdonahoe.kotlinoverpass.query.extensions

import java.lang.StringBuilder

fun StringBuilder.appendNewlineIf(text: String, newline: Boolean) =
    apply {
        if (newline) append(text).appendLine() else append(text)
    }