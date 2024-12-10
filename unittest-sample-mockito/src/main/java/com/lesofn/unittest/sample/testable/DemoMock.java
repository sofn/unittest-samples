package com.lesofn.unittest.sample.testable;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author sofn
 * @since 2022-05-18 16:36
 */
public class DemoMock {
    /**
     * method with new operation
     */
    /*public String newFunc() {
        BlackBox component = new BlackBox("something");
        return component.get();
    }*/

    /**
     * method with member method invoke
     */
    public String outerFunc(String s) throws Exception {
        return "{ \"res\": \"" + innerFunc(s) + staticFunc() + "\"}";
    }

    /**
     * method with common method invoke
     */
    public String commonFunc() {
        return "anything".trim() + "__" + "anything".substring(1, 2) + "__" + "abc".startsWith("ab");
    }

    /**
     * method with static method invoke
     */
   /* public BlackBox getBox() {
        return BlackBox.secretBox();
    }*/

    /**
     * two methods invoke same private method
     */
    public String callerOne() {
        return callFromDifferentMethod();
    }

    public String callerTwo() {
        return callFromDifferentMethod();
    }

    private static String staticFunc() {
        return "_STATIC_TAIL";
    }

    private String innerFunc(String s) throws Exception {
        return Files.readAllLines(Paths.get("/a-not-exist-file")).stream().collect(Collectors.joining());
    }

    private String callFromDifferentMethod() {
        return "realOne";
    }

}
