import com.compiler.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.*
import org.junit.jupiter.params.provider.MethodSource

class InterpretTest {
    @ParameterizedTest
    @MethodSource("examples")
    fun `it interprets a statement`(statement: Statement, expectedResult: String) {
        assertThat(interpret(statement), equalTo(expectedResult))
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
