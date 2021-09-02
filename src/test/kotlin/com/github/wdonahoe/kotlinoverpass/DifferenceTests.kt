package com.github.wdonahoe.kotlinoverpass

import com.github.wdonahoe.kotlinoverpass.query.builders.Overpass.Companion.overpass
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.Union
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.Node
import org.junit.Assert
import org.junit.Test

class DifferenceTests {
    @Test
    fun test_difference() {

        val query = overpass()
            .difference(
                Node.nodes(1),
                Node.nodes(2)
            )
        .build()

        Assert.assertEquals(
            """
                (
                    node(1);
                    -
                    node(2);
                );
            """.trimIndent(),
            query.toString()
        )
    }

    @Test
    fun difference_with_nested_union(){
        val query = overpass()
            .difference(
                Union.union {
                    nodes(1,2,3)
                    nodes(2,3,4)
                },
                Node.nodes(4,5,6)
            )
            .build()

        Assert.assertEquals(
            """
                (
                    (
                        node(id:1,2,3);
                        node(id:2,3,4);
                    );
                    -
                    node(id:4,5,6);
                );
            """.trimIndent(),
            query.toString()
        )
    }
}