@file:JvmName("_backward_compatibility")

package ru.landgrafhomyak.parser_stream.v2

import kotlin.jvm.JvmName

@Deprecated("Parser wouldn't support non-char streams so no mention of 'Char' is required", replaceWith = ReplaceWith("Predicate", "ru.landgrafhomyak.parser_stream.Predicate"))
typealias CharPredicate = Predicate
