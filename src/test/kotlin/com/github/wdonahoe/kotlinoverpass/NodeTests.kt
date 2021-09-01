package com.github.wdonahoe.kotlinoverpass

import com.github.wdonahoe.kotlinoverpass.query.builders.Overpass.Companion.overpass
import org.junit.Assert
import org.junit.Test

class NodeTests {
    @Test
    fun test_raw_nodes() {
        val query = overpass()
            .nodes("\"raw\"")
            .nodes("raw")
            .build()

        Assert.assertEquals(
            """
                node["raw"];
                node[raw];
            """.trimIndent(),
            query.toString()
        )
    }

    @Test
    fun test_id_nodes() {
        val query = overpass {
            nodes(1)
            nodes(1, 2, 3)
            nodes(listOf(2, 3, 4))
        }.build()

        Assert.assertEquals(
            """
                node(1);
                node(id:1,2,3);
                node(id:2,3,4);
            """.trimIndent(),
            query.toString()
        )
    }

    @Test
    fun test_settings_with_nodes() {
        val query = overpass {
            settings {
                timeout(25)
            }
            nodes(1)
        }.build()

        Assert.assertEquals(
            """
                [timeout:25];
                node(1);
            """.trimIndent(),
            query.toString()
        )
    }
}