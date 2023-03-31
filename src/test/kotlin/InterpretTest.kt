import com.compiler.LastExpressionList
import com.compiler.Number
import com.compiler.PrintStatement
import com.compiler.interpret
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InterpretTest {
    @Test
    fun `it interprets a statement`() {
        assertEquals(
            """1

            """.trimIndent(),
            interpret(PrintStatement(LastExpressionList(Number(1))))
        )
    }
}
