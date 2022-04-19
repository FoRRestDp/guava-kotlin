package com.github.forrestdp.guava.kotlin.graph

import com.google.common.annotations.Beta
import com.google.common.graph.ElementOrder
import com.google.common.graph.Graph
import com.google.common.graph.GraphBuilder
import com.google.common.graph.ImmutableGraph
import com.google.common.graph.MutableGraph

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public fun <T> mutableGraph(
    directed: Boolean,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    nodeOrder: ElementOrder<T>? = null,
    incidentEdgeOrder: ElementOrder<T>? = null,
): MutableGraph<T> {
    val builder = if (directed) GraphBuilder.directed() else GraphBuilder.undirected()
    builder.setup(
        allowsSelfLoops,
        expectedNodeCount,
        nodeOrder as ElementOrder<Any>,
        incidentEdgeOrder as ElementOrder<Any>,
    )
    return builder.build()
}

@Suppress("UnstableApiUsage")
@Beta
public fun <T> mutableGraph(
    from: Graph<T>,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    nodeOrder: ElementOrder<T>? = null,
    incidentEdgeOrder: ElementOrder<T>? = null,
): MutableGraph<T> {
    val builder = GraphBuilder.from(from)
    builder.setup<T>(allowsSelfLoops, expectedNodeCount, nodeOrder, incidentEdgeOrder)
    return builder.build()
}

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public inline fun <T> buildImmutableGraph(
    directed: Boolean,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    nodeOrder: ElementOrder<T>? = null,
    incidentEdgeOrder: ElementOrder<T>? = null,
    builderAction: ImmutableGraph.Builder<T>.() -> Unit,
): ImmutableGraph<T> {
    val builder = if (directed) GraphBuilder.directed() else GraphBuilder.undirected()
    builder.setup(
        allowsSelfLoops,
        expectedNodeCount,
        nodeOrder as ElementOrder<Any>,
        incidentEdgeOrder as ElementOrder<Any>,
    )
    return builder.immutable<T>().apply(builderAction).build()
}

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public inline fun <T> buildImmutableGraph(
    from: Graph<T>,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    nodeOrder: ElementOrder<T>? = null,
    incidentEdgeOrder: ElementOrder<T>? = null,
    builderAction: ImmutableGraph.Builder<T>.() -> Unit,
): ImmutableGraph<T> {
    val builder = GraphBuilder.from(from)
    builder.setup(
        allowsSelfLoops,
        expectedNodeCount,
        nodeOrder,
        incidentEdgeOrder,
    )
    return builder.immutable<T>().apply(builderAction).build()
}

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public fun <T> emptyImmutableGraph(
    directed: Boolean,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    nodeOrder: ElementOrder<T>? = null,
    incidentEdgeOrder: ElementOrder<T>? = null,
): ImmutableGraph<T> {
    val builder = if (directed) GraphBuilder.directed() else GraphBuilder.undirected()
    builder.setup(
        allowsSelfLoops,
        expectedNodeCount,
        nodeOrder as ElementOrder<Any>,
        incidentEdgeOrder as ElementOrder<Any>,
    )
    return builder.immutable<T>().build()
}

@Suppress("UnstableApiUsage", "UNCHECKED_CAST")
@Beta
public fun <T> emptyImmutableGraph(
    from: Graph<T>,
    allowsSelfLoops: Boolean = false,
    expectedNodeCount: Int? = null,
    nodeOrder: ElementOrder<T>? = null,
    incidentEdgeOrder: ElementOrder<T>? = null,
): ImmutableGraph<T> {
    val builder = GraphBuilder.from(from)
    builder.setup(
        allowsSelfLoops,
        expectedNodeCount,
        nodeOrder,
        incidentEdgeOrder,
    )
    return builder.immutable<T>().build()
}

@Suppress("UnstableApiUsage")
@PublishedApi
internal fun <T> GraphBuilder<T>.setup(
    allowsSelfLoops: Boolean,
    expectedNodeCount: Int?,
    nodeOrder: ElementOrder<T>?,
    incidentEdgeOrder: ElementOrder<T>?,
) {
    allowsSelfLoops(allowsSelfLoops)
    expectedNodeCount?.let { expectedNodeCount(it) }
    nodeOrder?.let { nodeOrder(it) }
    incidentEdgeOrder?.let { incidentEdgeOrder(it) }
}
