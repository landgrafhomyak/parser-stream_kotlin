@file:Suppress("REDUNDANT_INLINE_SUSPEND_FUNCTION_TYPE")
@file:OptIn(ExperimentalContracts::class)

package ru.landgrafhomyak.parser_stream

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

suspend inline fun <CS : CollectedSubstring, R> SourceStream<*, CS>.collect(predicate: Predicate, action: suspend (CS) -> R): R? {
	contract {
		callsInPlace(action, InvocationKind.EXACTLY_ONCE)
	}

	val s = this.collect(predicate) ?: return null
	try {
		return action(s)
	} finally {
		s.release()
	}
}

suspend inline fun <CS : CollectedSubstring, R> SourceStream<*, CS>.collectOrNull(predicate: Predicate, action: suspend (CS?) -> R): R {
	contract {
		callsInPlace(action, InvocationKind.EXACTLY_ONCE)
	}

	val s = this.collect(predicate)
	if (s == null) {
		return action(null)
	} else {
		try {
			return action(s)
		} finally {
			s.release()
		}
	}
}

suspend inline fun <P : Pos, R> SourceStream<P, *>.pos(action: suspend (P) -> R): R? {
	contract {
		callsInPlace(action, InvocationKind.EXACTLY_ONCE)
	}

	val s = this.pos
	try {
		return action(s)
	} finally {
		s.release()
	}
}