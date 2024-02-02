package com.lesofn.unittest.sample.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * 类上的注解相当于：
 *
 * @date 2022-05-17 20:02
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class Test5_Argument {

    @Mock
    private List<Integer> list;

    /**
     * any()
     */
    @Test
    void hello() {
        given(list.get(anyInt())).willReturn(100);
        assertEquals(100, list.get(1));

        Mockito.verify(list).get(1);
    }

    /**
     * any()
     */
    @Test
    void testAny() {
        given(list.get(any(Integer.class))).willReturn(100);
        assertEquals(100, list.get(1));

        Mockito.verify(list).get(1);
    }

}
