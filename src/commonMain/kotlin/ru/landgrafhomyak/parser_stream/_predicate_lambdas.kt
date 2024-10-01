@file:JvmName("_PredicateLambdas")

package ru.landgrafhomyak.parser_stream

import kotlin.jvm.JvmName

@Suppress("ObjectPropertyName")
private const val _deprecationMessage = "Using anonymous lambdas may decrease performance"

@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
annotation class SourceStreamLambdas

@SourceStreamLambdas
@Deprecated(message = _deprecationMessage, level = DeprecationLevel.WARNING)
suspend inline fun <CS : CollectedSubstring> SourceStream<*, CS>.collect(crossinline predicate: (Char) -> Boolean): CS? {
	val wrappedPredicate = object : Predicate {
		override fun check(c: Char): Boolean = predicate(c)
	}

	return this.collect(wrappedPredicate)
}

@SourceStreamLambdas
@Deprecated(message = _deprecationMessage, level = DeprecationLevel.WARNING)
suspend inline fun <CS : CollectedSubstring> SourceStream<*, CS>.skip(crossinline predicate: (Char) -> Boolean): UInt {
	val wrappedPredicate = object : Predicate {
		override fun check(c: Char): Boolean = predicate(c)
	}

	return this.skip(wrappedPredicate)
}