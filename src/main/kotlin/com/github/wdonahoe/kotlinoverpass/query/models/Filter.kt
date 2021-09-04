package com.github.wdonahoe.kotlinoverpass.query.models

data class Filter(
    val key: String,
    val operator: Operator,
    val value: String,
    val position: Operator.Position = Operator.Position.Infix,
    var isCaseInsensitive: Boolean = false
) {
    override fun toString(): String {
        val sb = StringBuilder()
        val op = operator.value

        sb.append("[")
        if (position == Operator.Position.Prefix) {
            sb.append(op)
        }

        sb.append(if (key.contains(spaces)) "\"$key\"" else key)

        if (position == Operator.Position.Infix) {
            sb.append(op)
        }

        sb.append(if (value.contains(spaces)) "\"$value\"" else value)
        sb.append("${if (isCaseInsensitive) ",i" else ""}]")

        return sb.toString()
    }

    companion object {
        val spaces = "\\s+".toRegex()
    }
}