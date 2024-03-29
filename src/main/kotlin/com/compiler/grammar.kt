package com.compiler

sealed class Statement
data class CompoundStatement(val statement1: Statement, val statement2: Statement) : Statement()
data class AssignmentStatement(val identifier: String, val expression: Expression): Statement()
data class PrintStatement(val expressions: ExpressionList): Statement()

sealed class Expression
data class Identifier(val name: String) : Expression()
data class Number(val value: Int) : Expression()

enum class Operator {
    PLUS, MINUS, TIMES, DIVIDE
}
data class OperatorExpression(val left: Expression, val operator: Operator, val right: Expression) : Expression()

data class StatementThenExpression(val statement: Statement, val expression: Expression) : Expression()

sealed class ExpressionList {
    abstract fun size(): Int
}

data class PairExpressionList(val head: Expression, val tail: ExpressionList): ExpressionList() {
    override fun size(): Int = 1 + tail.size()
}

data class LastExpressionList(val expression: Expression): ExpressionList() {
    override fun size(): Int = 1
}
