package com.github.forrestdp.guava.kotlin.graph

import com.google.common.annotations.Beta
import com.google.common.graph.ElementOrder
import com.google.common.graph.ImmutableNetwork
import com.google.common.graph.MutableNetwork
import com.google.common.graph.Network
import com.google.common.graph.NetworkBuilder

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public fun <N, E> mutableNetwork(
    directed: Boolean,
    allowsParallelEdges: Boolean = false,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    expectedEdgeCount: Int? = null,
    nodeOrder: ElementOrder<N>? = null,
    edgeOrder: ElementOrder<E>? = null,
): MutableNetwork<N, E> {
    val builder = if (directed) NetworkBuilder.directed() else NetworkBuilder.undirected()
    builder.setup(
        allowsParallelEdges,
        allowsSelfLoops,
        expectedNodeCount,
        expectedEdgeCount,
        nodeOrder as ElementOrder<Any>,
        edgeOrder as ElementOrder<Any>,
    )
    return builder.build()
}

@Suppress("UnstableApiUsage")
@Beta
public fun <N, E> mutableNetwork(
    from: Network<N, E>,
    allowsParallelEdges: Boolean = false,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    expectedEdgeCount: Int? = null,
    nodeOrder: ElementOrder<N>? = null,
    edgeOrder: ElementOrder<E>? = null,
): MutableNetwork<N, E> {
    val builder = NetworkBuilder.from(from)
    builder.setup<N, E>(
        allowsParallelEdges,
        allowsSelfLoops,
        expectedNodeCount,
        expectedEdgeCount,
        nodeOrder,
        edgeOrder,
    )
    return builder.build()
}

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public inline fun <N, E> buildImmutableNetwork(
    directed: Boolean,
    allowsParallelEdges: Boolean = false,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    expectedEdgeCount: Int? = null,
    nodeOrder: ElementOrder<N>? = null,
    edgeOrder: ElementOrder<E>? = null,
    builderAction: ImmutableNetwork.Builder<N, E>.() -> Unit,
): ImmutableNetwork<N, E> {
    val builder = if (directed) NetworkBuilder.directed() else NetworkBuilder.undirected()
    builder.setup(
        allowsParallelEdges,
        allowsSelfLoops,
        expectedNodeCount,
        expectedEdgeCount,
        nodeOrder as ElementOrder<Any>,
        edgeOrder as ElementOrder<Any>,
    )
    return builder.immutable<N, E>().apply(builderAction).build()
}

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public inline fun <N, E> buildImmutableNetwork(
    from: Network<N, E>,
    allowsParallelEdges: Boolean = false,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    expectedEdgeCount: Int? = null,
    nodeOrder: ElementOrder<N>? = null,
    edgeOrder: ElementOrder<E>? = null,
    builderAction: ImmutableNetwork.Builder<N, E>.() -> Unit,
): ImmutableNetwork<N, E> {
    val builder = NetworkBuilder.from(from)
    builder.setup<N, E>(
        allowsParallelEdges,
        allowsSelfLoops,
        expectedNodeCount,
        expectedEdgeCount,
        nodeOrder,
        edgeOrder,
    )
    return builder.immutable<N, E>().apply(builderAction).build()
}

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public fun <N, E> emptyImmutableNetwork(
    directed: Boolean,
    allowsParallelEdges: Boolean = false,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    expectedEdgeCount: Int? = null,
    nodeOrder: ElementOrder<N>? = null,
    edgeOrder: ElementOrder<E>? = null,
): ImmutableNetwork<N, E> {
    val builder = if (directed) NetworkBuilder.directed() else NetworkBuilder.undirected()
    builder.setup(
        allowsParallelEdges,
        allowsSelfLoops,
        expectedNodeCount,
        expectedEdgeCount,
        nodeOrder as ElementOrder<Any>,
        edgeOrder as ElementOrder<Any>,
    )
    return builder.immutable<N, E>().build()
}

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public fun <N, E> emptyImmutableNetwork(
    from: Network<N, E>,
    allowsParallelEdges: Boolean = false,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    expectedEdgeCount: Int? = null,
    nodeOrder: ElementOrder<N>? = null,
    edgeOrder: ElementOrder<E>? = null,
): ImmutableNetwork<N, E> {
    val builder = NetworkBuilder.from(from)
    builder.setup<N, E>(
        allowsParallelEdges,
        allowsSelfLoops,
        expectedNodeCount,
        expectedEdgeCount,
        nodeOrder,
        edgeOrder,
    )
    return builder.immutable<N, E>().build()
}

@Suppress("UnstableApiUsage")
@PublishedApi
internal fun <N, E> NetworkBuilder<N, E>.setup(
    allowsParallelEdges: Boolean,
    allowsSelfLoops: Boolean,
    expectedNodeCount: Int?,
    expectedEdgeCount: Int?,
    nodeOrder: ElementOrder<N>?,
    edgeOrder: ElementOrder<E>?,
) {
    allowsParallelEdges(allowsParallelEdges)
    allowsSelfLoops(allowsSelfLoops)
    expectedNodeCount?.let { expectedNodeCount(it) }
    expectedEdgeCount?.let { expectedEdgeCount(it) }
    nodeOrder?.let { nodeOrder(it) }
    edgeOrder?.let { edgeOrder(it) }
}
