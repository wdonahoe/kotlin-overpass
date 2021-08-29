package com.github.wdonahoe.kotlinoverpass

import com.github.wdonahoe.kotlinoverpass.query.extensions.toBoundingBox
import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox
import org.junit.Assert
import org.junit.Test
import org.locationtech.jts.geom.Envelope

class BoundingBoxTests {

    @Test
    fun testRender() {
        val bbox = Envelope(1.0,2.0,3.0,4.0).toBoundingBox()

        Assert.assertEquals("[bbox:1.0,2.0,3.0,4.0]","$bbox")
    }
}