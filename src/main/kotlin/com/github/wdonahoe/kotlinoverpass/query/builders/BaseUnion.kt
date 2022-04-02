package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.builders.statements.Difference
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.Statement
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.Union
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.Node
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.relation.Relation
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.way.Way
import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox
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

        fun nodes(bbox: BoundingBox) =
            apply {
                Node.nodes(bbox).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun <M : Statement> nodes(builder: Statement.Builder<M>) =
            apply {
                childBuilders.add(builder)
            }

        fun ways(raw: String) =
            apply {
                Way.ways(raw).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun ways(vararg ids: Int) =
            apply {
                Way.ways(*ids).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun ways(ids: Collection<Int>) =
            apply {
                Way.ways(ids).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun ways(vararg filters: Filter) =
            apply {
                Way.ways(*filters).let { builder ->
                    childBuilders.add(builder)
                }
            }

        @JvmName("ways1")
        fun ways(filters: Collection<Filter>) =
            apply {
                Way.ways(filters).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun ways(bbox: BoundingBox) =
            apply {
                Way.ways(bbox).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun relations(raw: String) =
            apply {
                Relation.relations(raw).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun relations(vararg ids: Int) =
            apply {
                Relation.relations(*ids).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun relations(ids: Collection<Int>) =
            apply {
                Relation.relations(ids).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun relations(vararg filters: Filter) =
            apply {
                Relation.relations(*filters).let { builder ->
                    childBuilders.add(builder)
                }
            }

        @JvmName("relations1")
        fun relations(filters: Collection<Filter>) =
            apply {
                Relation.relations(filters).let { builder ->
                    childBuilders.add(builder)
                }
            }

        fun relations(bbox: BoundingBox) =
            apply {
                Relation.relations(bbox).let { builder ->
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