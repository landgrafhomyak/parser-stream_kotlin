package ru.landgrafhomyak.parser_stream.v2

/**
 * Multiplatform predicate functional interface for [Char].
 * Must be stateless.
 *
 * Missing `fun` modifier is not a mistake.
 *
 * @see Predicate.check
 * @see SourceStream.collect
 * @see SourceStream.skip
 */
interface Predicate {
	/**
	 * Returns `true` if stream should continue [collecting][SourceStream.collect]
	 * or [skipping][SourceStream.skip] or `false` if it should stop.
	 * @see SourceStream.collect
	 * @see SourceStream.skip
	 */
	fun check(c: Char): Boolean
}
