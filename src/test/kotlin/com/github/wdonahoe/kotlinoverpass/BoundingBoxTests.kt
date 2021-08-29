package com.github.wdonahoe.kotlinoverpass

import com.github.wdonahoe.kotlinoverpass.query.builders.BoundingBox
import org.junit.Assert
import org.junit.Test
import org.locationtech.jts.geom.Envelope

class BoundingBoxTests {

    @Test
    fun testRender() {
        val bbox = BoundingBox(Envelope(1.0,2.0,3.0,4.0))

        Assert.assertEquals("[bbox:1.0,2.0,3.0,4.0]","$bbox")
    }
}