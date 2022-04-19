package com.github.forrestdp.guava.kotlin.hash

import com.google.common.annotations.Beta
import com.google.common.hash.HashCode
import com.google.common.hash.HashFunction
import com.google.common.hash.Hasher

@Suppress("UnstableApiUsage")
@Beta
public inline fun HashFunction.hash(builderAction: Hasher.() -> Unit): HashCode =
    newHasher().apply(builderAction).hash()

@Suppress("UnstableApiUsage")
@Beta
public inline fun HashFunction.hash(expectedInputSize: Int, builderAction: Hasher.() -> Unit): HashCode =
    newHasher(expectedInputSize).apply(builderAction).hash()
