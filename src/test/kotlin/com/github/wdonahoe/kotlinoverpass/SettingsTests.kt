package com.github.wdonahoe.kotlinoverpass

import com.github.wdonahoe.kotlinoverpass.query.builders.Overpass.Companion.overpass
import org.junit.Assert
import org.junit.Test
import java.time.OffsetDateTime

class SettingsTests {

    @Test
    fun test_settins() {
        val query = overpass {
            settings {
                bbox(1.0, 2.0, 3.0, 4.0)
                timeout(25)
                date("2021-08-28T05:30:01Z")
            }
        }

        Assert.assertEquals("[bbox:1.0,2.0,3.0,4.0][timeout:25][date:2021-08-28T05:30:01Z];", "$query")
    }
}