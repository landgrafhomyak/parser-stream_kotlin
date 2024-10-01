package ru.landgrafhomyak.parser_stream

/**
 * Common interface for builders.
 * Each method of this object must finalize it and return [new state][BuilderState] or [return type, specified in generic][R].
 *
 * @param P Real type of [stream position][Pos] for typesafe using with [builders][BuilderState].
 * @param CS Real type of [collected strings][CollectedSubstring] for typesafe using with [builders][BuilderState].
 * @param R Type (often another [BuilderState] inheritor) which should be returned on exit from current parser scope.
 *          For example, states related for parsing function may have returned states `<..., ClassBuilder>` or `<..., FileBuilder>`.
 */
interface BuilderState<in P : Pos, in CS : CollectedSubstring, out R>

