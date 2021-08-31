package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.Rendered

abstract class RenderedBuilder<T : Rendered> {
    abstract fun build() : T
}