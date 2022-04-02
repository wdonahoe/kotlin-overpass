package com.github.wdonahoe.kotlinoverpass

import com.github.wdonahoe.kotlinoverpass.query.builders.Overpass.Companion.overpass
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.IdFilter
import com.github.wdonahoe.kotlinoverpass.query.builders.statements.node.TagFilter
import com.github.wdonahoe.kotlinoverpass.query.extensions.FilterExtensions.`!=`
import com.github.wdonahoe.kotlinoverpass.query.extensions.FilterExtensions.`!~`
import com.github.wdonahoe.kotlinoverpass.query.extensions.FilterExtensions.`=`
import com.github.wdonahoe.kotlinoverpass.query.extensions.FilterExtensions.`~`
import com.github.wdonahoe.kotlinoverpass.query.extensions.FilterExtensions.caseInsensitive
import com.github.wdonahoe.kotlinoverpass.query.extensions.FilterExtensions.notExists
import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox
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

    @Test
    fun test_tag_filter_nodes() {
        val query = overpass {
            nodes(
                "amenity" `=` "fire station",
                "address" `~` "Fairfax"
            )
            nodes(
                "route" `!~` "66",
                ("key" `!=` "value").caseInsensitive(),
            )
            nodes("contains spaces" `=` "also contains spaces")
            nodes("name".notExists())
        }.build()

        Assert.assertEquals(
            """
                node[amenity="fire station"][address~Fairfax];
                node[route!~66][key!=value,i];
                node["contains spaces"="also contains spaces"];
                node[!name];
            """.trimIndent(),
            query.toString()
        )
    }

    @Test
    fun test_bbox_filter() {
        val query = overpass()
            .nodes(BoundingBox(10.0, 11.0, 12.0, 13.0))
            .build()

        Assert.assertEquals(
            """
                node(10.0,11.0,12.0,13.0);
            """.trimIndent(),
            query.toString()
        )
    }

    @Test
    fun test_blah() {
        val query = overpass {
            nodes(5,6,7)
            nodes(
                IdFilter
                    .Builder(1,2,3)
                    .toSet("a"))
            nodes(
                TagFilter
                    .Builder(
                        listOf(
                            "amenity" `=` "fire station",
                            "address" `~` "Fairfax"
                        )
                    )
                    .toSet("b")
            )
        }.build()

        Assert.assertEquals(
            """
                node(id:5,6,7);
                node(id:1,2,3)->.a;
                node[amenity="fire station"][address~Fairfax]->.b;
            """.trimIndent(),
            query.toString()
        )
    }
}