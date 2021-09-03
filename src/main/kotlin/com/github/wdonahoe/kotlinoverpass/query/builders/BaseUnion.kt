package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.Difference
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.Statement
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.Union
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.Node
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.NodeTagFilter
import com.github.wdonahoe.kotlinoverpass.query.models.Filter

abstract class BaseUnion(
    protected val builder: Builder<*>,
    indent: String,
    newline: Boolean
) : Statement(
    indent,
    newline
) {
    protected val childBuilders get() = builder.childBuilders

    abstract class Builder<T : BaseUnion> : Statement.Builder<T>() {

        internal val childBuilders = mutableListOf<Statement.Builder<*>>()

        fun nodes(raw: String) =
            apply {
                Node.nodes(raw).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun nodes(vararg ids: Int) =
            apply {
                Node.nodes(*ids).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun nodes(ids: Collection<Int>) =
            apply {
                Node.nodes(ids).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun nodes(vararg filters: Filter) =
            apply {
                Node.nodes(*filters).let { builder ->
                    childBuilders.add(builder)
                }
            }

        @JvmName("nodes1")
        fun nodes(filters: Collection<Filter>) =
            apply {
                Node.nodes(filters).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun union(init: (Union.Builder.() -> Unit)) =
            apply {
                Union.union(init).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun difference(builder1: Statement.Builder<*>, builder2: Statement.Builder<*>) =
            apply {
                Difference.difference(builder1, builder2).let { builder ->
                    childBuilders.add(builder)
                }
            }
    }
}