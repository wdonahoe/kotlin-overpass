package com.github.wdonahoe.kotlinoverpass.query.models

enum class Operator(val value: String) {
    Equals("="),
    NotEquals("!="),
    Matches("~"),
    NotMatches("!~"),
    Exists(""),
    NotExists("!");

    enum class Position {
        Prefix,
        Infix,
        Both,
        None
    }
}