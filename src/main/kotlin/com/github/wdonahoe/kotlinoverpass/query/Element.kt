package com.github.wdonahoe.kotlinoverpass.query

abstract class Element : Rendered() {
    protected abstract val children: Sequence<Rendered>
}