package com.lesofn.unittest.sample.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

/**
 * @author sofn
 * @since 2022-05-17 20:02
 */

public class Test1_Hello {

    @Test
    void helloMock() {
        List<String> list = mock(List.class);
        list.add("1");
        list.add("2");

        // will get null. The previous step is just recording the behavior and no data is added to the list.
        assertNull(list.get(0));

        verify(list).add("1"); // correct, because the behavior is remembered
        // verify(list).add("3"); // throw error because this behavior was not recorded before
    }



}
