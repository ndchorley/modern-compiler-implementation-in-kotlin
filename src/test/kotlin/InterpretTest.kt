import com.compiler.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.*
import org.junit.jupiter.params.provider.MethodSource

class InterpretTest {
    @ParameterizedTest
    @MethodSource("examples")
    fun `it interprets a statement`(statement: Statement, expectedResult: String) {
        assertEquals(expectedResult, interpret(statement))
    }

    companion object {
        @JvmStatic
        private fun examples() =
            listOf(
                arguments(
                    PrintStatement(LastExpressionList(Number(1))),
                    """1

                    """.trimIndent()
                ),

                arguments(
                    PrintStatement(
                        PairExpressionList(
                            Number(1),
                            PairExpressionList(
                                Number(2),
                                LastExpressionList(Number(3))
                            )
                        )
                    ),
                    """1 2 3

                    """.trimIndent()
                )
            )
    }
}
