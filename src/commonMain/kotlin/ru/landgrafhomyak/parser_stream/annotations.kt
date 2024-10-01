package ru.landgrafhomyak.parser_stream

/**
 * Function of AST-builder marked with this annotation generates parser error to parser output (not throws).
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Error


/**
 * Function of AST-builder marked with this annotation generates parser warning to parser output.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Warning


/**
 * Function or parameter of AST-builder marked with this annotation used only for highlighting in IDEs and may be omitted.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
annotation class HighlightOnly