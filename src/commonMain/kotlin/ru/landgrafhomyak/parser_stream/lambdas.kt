package ru.landgrafhomyak.parser_stream

@Suppress("ObjectPropertyName")
private const val _deprecationMessage = "Using anonymous lambdas may decrease performance"

@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
annotation class SourceStreamLambdas

@SourceStreamLambdas
@Deprecated(message = _deprecationMessage, level = DeprecationLevel.WARNING)
suspend inline fun <CS : CollectedSubstring> SourceStream<CS, *>.collect(limit: UInt, crossinline predicate: (Char) -> Boolean): CS? {
    val wrappedPredicate = object : CharPredicate {
        override fun check(c: Char): Boolean = predicate(c)
    }

    return this.collect(wrappedPredicate, limit)
}

@SourceStreamLambdas
@Deprecated(message = _deprecationMessage, level = DeprecationLevel.WARNING)
suspend inline fun <CS : CollectedSubstring> SourceStream<CS, *>.skip(crossinline predicate: (Char) -> Boolean): UInt {
    val wrappedPredicate = object : CharPredicate {
        override fun check(c: Char): Boolean = predicate(c)
    }

    return this.skip(wrappedPredicate)
}