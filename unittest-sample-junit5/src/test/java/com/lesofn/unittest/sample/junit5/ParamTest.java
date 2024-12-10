package com.lesofn.unittest.sample.junit5;

import com.google.common.collect.ImmutableList;
import com.lesofn.unittest.common.Fibonacci;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Multi-parameter testing
 * <p>
 * need import jar： junit-jupiter-params
 *
 * @author sofn
 * @since 2022-05-17 17:56
 */
public class ParamTest {


    /**
     * These values will be automatically passed to the parameter value,
     * and the length of the array is the number of times the method is executed.
     */
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    public void test(String str) {
        assertNotNull(str);
    }


    /**
     * Provide multiple types of data
     *
     * @param input
     * @param expected
     */
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "3, 2", "6, 8"})
    public void testCsv(int input, int expected) {
        assertEquals(expected, Fibonacci.fibonacci(input));
    }

    /**
     * Csv files provide multiple types of large batches of data
     *
     * @param input
     * @param expected
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void testCsvFile(int input, int expected) {
        assertEquals(expected, Fibonacci.fibonacci(input));
    }

    /**
     * method supply data
     *
     * @param arg
     * @param value
     */
    @ParameterizedTest
    @MethodSource("provider")
    void testParameterized(String arg, Integer value) {
        System.out.println(arg + "-" + value);
    }

    static List<Arguments> provider() {
        return ImmutableList.of(Arguments.of("arg1", 1), Arguments.of("arg2", 2));
    }

    /**
     * ArgumentsProvider implementation class provides data
     *
     * @param arg
     * @param value
     */
    @ParameterizedTest
    @ArgumentsSource(DataProvider.class)
    void testArgumentsSource(String arg, Integer value) {
        System.out.println(arg + "-" + value);
    }

    static class DataProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(Arguments.of("arg1", 1), Arguments.of("arg2", 2));
        }
    }

    /**
     * Enumeration class provides data
     *
     * @param season
     */
    @ParameterizedTest
    @EnumSource(value = Season.class, names = {"SPRING", "WINTER"}, mode = EnumSource.Mode.INCLUDE)
    void testSeasonEnum(Season season) {
        System.out.println(season);
    }

    enum Season {
        SPRING, SUMMER, FALL, WINTER
    }
}
