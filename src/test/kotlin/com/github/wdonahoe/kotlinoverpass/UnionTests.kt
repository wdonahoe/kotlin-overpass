package com.github.wdonahoe.kotlinoverpass

import com.github.wdonahoe.kotlinoverpass.query.builders.Overpass.Companion.overpass
import org.junit.Assert
import org.junit.Test

class UnionTests {
    @Test
    fun test_union() {
        val query = overpass {
            union {
                nodes(1,2,3)
                nodes(4,5,6)
            }
        }

        Assert.assertEquals(
            """
            (
                node(id:1,2,3);
                node(id:4,5,6);
            );
            """.trimIndent(),
            query.toString()
        )
    }

    @Test
    fun test_nested_union() {
        val query = overpass {
            union {
                nodes(1,2,3)
                union {
                    nodes(""""attr"="value"""")
                    union {
                        nodes(4,5,6)
                        nodes(7,8,9)
                    }
                }
            }
        }.build()

        Assert.assertEquals(
            """
                (
                    node(id:1,2,3);
                    (
                        node["attr"="value"];
                        (
                            node(id:4,5,6);
                            node(id:7,8,9);
                        );
                    );
                );
            """.trimIndent(),
            query.toString()
        )
    }
}