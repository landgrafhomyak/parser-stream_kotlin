package ru.landgrafhomyak.parser_stream

/**
 * Multiplatform predicate functional interface for [Char].
 *
 * Missing `fun` modifier is not a mistake.
 *
 * @see CharPredicate.check
 * @see SourceStream.collect
 * @see SourceStream.skip
 */
interface CharPredicate {
    /**
     * Returns `true` if stream should continue [collecting][SourceStream.collect]
     * or [skipping][SourceStream.skip] or `false` if it should stop.
     * @see SourceStream.collect
     * @see SourceStream.skip
     */
    fun check(c: Char): Boolean
}
