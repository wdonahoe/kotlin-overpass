package com.github.wdonahoe.kotlinoverpass.query.extensions

import com.github.wdonahoe.kotlinoverpass.query.models.BoundingBox
import org.locationtech.jts.geom.Envelope
import org.locationtech.jts.geom.Geometry

fun Envelope.toBoundingBox() = BoundingBox(minX, maxX, minY, maxY)

fun Geometry.toBoundingBox() = envelopeInternal.toBoundingBox()