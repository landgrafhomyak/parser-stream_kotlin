package ru.landgrafhomyak.parser_stream.v2

/**
 * Object containing meta-info about substring collected for future processing.
 */
interface CollectedSubstring {
	/**
	 * Compares collected symbols with specified [string][kw].
	 */
	fun compareKeyword(kw: String): Boolean

	/**
	 * Invoked when **parser** (not it's receiver) doesn't need this object anymore.
	 * This function must be called even if substring is *already* passed to receiver
	 * (so receiver should increase reference counter of this object by himself if needed).
	 */
	fun release()

	/**
	 * Size (in char units) of collected substring.
	 */
	val length: UInt
}