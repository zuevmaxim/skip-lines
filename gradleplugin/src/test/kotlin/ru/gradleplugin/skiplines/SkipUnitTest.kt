package ru.gradleplugin.skiplines

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class SkipUnitTest {
    @ParameterizedTest
    @MethodSource("provideStringsLists")
    fun skipTest(input: List<String>, expected: List<String>) {
        assertEquals(expected, SkipTask.skip(input))
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        private fun provideStringsLists(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("1", "2", "3"), listOf("1", "2", "3")),
                Arguments.of(emptyList<String>(), emptyList<String>()),
                Arguments.of(listOf("1", "#skip 1", "2", "3"), listOf("1", "3")),
                Arguments.of(listOf("#skip 10", "1", "2"), emptyList<String>()),
                Arguments.of(listOf("1", "2", "#skip 1aaa", "#skip 10", "3"), listOf("1", "2", "3")),
                Arguments.of(listOf(" #skip 2", "1", "2"), listOf(" #skip 2", "1", "2")),
                Arguments.of(listOf("#skip 10") + List(20) { it.toString() },
                    List(10) { (it + 10).toString() }),
                Arguments.of(listOf("#skip 100") + List(110) { it.toString() },
                    List(10) { (it + 100).toString() })
            )
        }
    }
}
