package com.lesofn.unittest.sample.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * 类上的注解相当于：
 *
 * @date 2022-05-17 20:02
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class Test5_Verify {

    @Mock
    private List<Integer> list;

    @Test
    void testTimes() {
        when(list.get(anyInt())).thenReturn(100);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(2));
        System.out.println(list.get(2));
        System.out.println(list.get(2));

        verify(list, times(7)).get(anyInt());
        verify(list, atLeastOnce()).get(0);
        verify(list, atLeast(3)).get(2);
        verify(list, atMost(6)).get(2);
        verify(list, atMost(1)).get(0);
    }

}
