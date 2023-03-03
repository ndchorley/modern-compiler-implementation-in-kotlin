package com.compiler

abstract class Statement
data class CompoundStatement(val statement1: Statement, val statement2: Statement) : Statement()
data class AssignmentStatement(val identifier: String, val expression: Expression): Statement()
data class PrintStatement(val expressions: ExpressionList): Statement()

abstract class Expression
data class Identifier(val name: String) : Expression()
data class Number(val value: Int) : Expression()

enum class Operator {
    PLUS, MINUS, TIMES, DIVIDE
}
data class OperatorExpression(val left: Expression, val operator: Operator, val right: Expression)

data class StatementThenExpression(val statement: Statement, val expression: Expression) : Expression()

abstract class ExpressionList
data class PairExpressionList(val head: Expression, val tail: ExpressionList): ExpressionList()
data class LastExpressionList(val expression: Expression): ExpressionList()

