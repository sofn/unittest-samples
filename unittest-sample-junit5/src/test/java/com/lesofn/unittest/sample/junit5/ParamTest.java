package com.lesofn.unittest.sample.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.common.collect.ImmutableList;
import com.lesofn.unittest.common.Fibonacci;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;


/**
 * 多参数化测试
 * 需要引入包： junit-jupiter-params
 *
 * @author sofn
 * @date 2022-05-17 17:56
 */
public class ParamTest {


    /**
     * 这些值将会被自动传给参数value，数组的长度便是方法执行的次数
     */
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    public void test(String str) {
        assertNotNull(str);
    }


    /**
     * 提供多类型数据
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
     * Csv文件提供多类型大批量数据
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
     * 方法供给数据
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
     * ArgumentsProvider实现类供给数据
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
     * 枚举类供给数据
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
