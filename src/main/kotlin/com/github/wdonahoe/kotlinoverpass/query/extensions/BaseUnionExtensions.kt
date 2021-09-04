@file:Suppress("PackageDirectoryMismatch")

package com.github.wdonahoe.kotlinoverpass.query.builders

import com.github.wdonahoe.kotlinoverpass.query.extensions.toBoundingBox
import org.locationtech.jts.geom.Envelope
import org.locationtech.jts.geom.Geometry

fun <T : BaseUnion> BaseUnion.Builder<T>.nodes(geometry: Geometry) =
    nodes(geometry.toBoundingBox())

fun <T : BaseUnion> BaseUnion.Builder<T>.nodes(envelope: Envelope) =
    nodes(envelope.toBoundingBox())

fun <T : BaseUnion> BaseUnion.Builder<T>.ways(geometry: Geometry) =
    ways(geometry.toBoundingBox())

fun <T : BaseUnion> BaseUnion.Builder<T>.ways(envelope: Envelope) =
    ways(envelope.toBoundingBox())

fun <T : BaseUnion> BaseUnion.Builder<T>.relations(geometry: Geometry) =
    relations(geometry.toBoundingBox())

fun <T : BaseUnion> BaseUnion.Builder<T>.relations(envelope: Envelope) =
    relations(envelope.toBoundingBox())
