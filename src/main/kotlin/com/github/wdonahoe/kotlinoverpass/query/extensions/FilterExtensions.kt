package com.github.wdonahoe.kotlinoverpass.query.extensions

import com.github.wdonahoe.kotlinoverpass.query.models.Filter
import com.github.wdonahoe.kotlinoverpass.query.models.Operator

object FilterExtensions {
    infix fun String.`=`(value: String) = isEqual(value)

    fun String.isEqual(value: String) = Filter(this, Operator.Equals, value)

    infix fun String.`!=`(value: String) = isNotEqual(value)

    fun String.isNotEqual(value: String) = Filter(this, Operator.NotEquals, value)

    infix fun String.`~`(value: String) = isMatch(value)

    fun String.isMatch(value: String) = Filter(this, Operator.Matches, value)

    infix fun String.`!~`(value: String) = isNotMatch(value)

    fun String.isNotMatch(value: String) = Filter(this, Operator.NotMatches, value)
}