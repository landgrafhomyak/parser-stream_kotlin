package ru.landgrafhomyak.parser_stream.v2

/**
 * Object containing meta-info (for receiver) about current stream's position.
 * Doesn't reflect actions on stream.
 */
interface Pos {
	/**
	 * Invoked when **parser** (not it's receiver) doesn't need this object anymore.
	 * This function must be called even if position is *already* passed to receiver
	 * (so receiver should increase reference counter of this object by himself if needed).
	 */
	fun release()
}
