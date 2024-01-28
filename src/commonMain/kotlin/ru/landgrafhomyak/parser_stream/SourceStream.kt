package ru.landgrafhomyak.parser_stream

import kotlin.coroutines.cancellation.CancellationException

/**
 * Asynchronous input char stream for parsing.
 *
 * Comparing to existing stdlib classes:
 * * [Java's Reader](https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html)
 *   is blocking while this stream and parsers built on it are asynchronous.
 * * [Java's Scanner](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)
 *   intended for getting parsed values (e.g., numbers, words), this stream intended for
 *   tokenizing and building [AST](https://en.wikipedia.org/wiki/Abstract_syntax_tree)
 * * This is 'input' interface for parser, functionality like 'close()' functions
 *   delegated to parser's invoker
 */
interface SourceStream<CS : CollectedSubstring, P : Pos> {
    /**
     * Collects symbols while [predicate][CharPredicate] returns `true`.
     * For parsing keywords, digits, indents in [Python](https://python.org/), etc.
     *
     * After function returns stream position set to symbol on which predicate returned `false`.
     *
     * @return [Substring instance][CollectedSubstring] or `null` if zero symbols collected.
     *
     * @throws CollectingLimitReached If size of collected substring greater than [limit param][limit].
     *
     * @see SourceStream.check
     * @see CollectedSubstring
     */
    @Throws(CollectingLimitReached::class, CancellationException::class)
    suspend fun collect(predicate: CharPredicate, limit: UInt): CS?

    /**
     * Skips symbols while [predicate][CharPredicate] returns `true`.
     * For skipping space symbols, etc.
     *
     * After function return stream position set to symbol on which predicate returned `false`.
     *
     * @return Count of skipped symbols.
     *
     * @see CharPredicate.check
     */
    suspend fun skip(predicate: CharPredicate): UInt

    /**
     * Object containing meta-info (for receiver) about current stream's position.
     */
    val pos: P

    /**
     * `true` if stream is at position after last symbol in the source.
     */
    val isEnded: Boolean

    /**
     * Moves stream position to the next symbol.
     * If the resulting position is after last symbol in the source returns `true`.
     * If the stream already [ended][SourceStream.isEnded] does nothing.
     */
    suspend fun move(): Boolean


    /**
     * Symbol at the current stream's position.
     * @throws IllegalStateException if the stream [is ended][SourceStream.isEnded].
     */
    val current: Char
}


