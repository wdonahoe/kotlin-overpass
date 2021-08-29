package com.github.wdonahoe.kotlinoverpass.query.builders

abstract class Element : Rendered() {
    protected abstract val children: Sequence<Rendered>
}