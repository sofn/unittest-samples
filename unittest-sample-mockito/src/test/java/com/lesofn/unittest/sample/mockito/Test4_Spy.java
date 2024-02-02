package com.lesofn.unittest.sample.mockito;

import com.lesofn.unittest.sample.testable.MyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 类上的注解相当于：
 *
 * @date 2022-05-17 20:02
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class Test4_Spy {

    /**
     * 如果没有实例化，会自动根据默认构造参数实例化1个对象
     */
    @Spy
    private MyService list;

    @Spy
    private MyService list2 = new MyService();

    @Test
    void helloSpy() {
        assertEquals(3, list.numAdd(1, 2));

        Mockito.verify(list).numAdd(1, 2);
    }

    @Test
    void testStub() {
        // 真实调用
        assertEquals(3, list2.numAdd(1, 2));

        // 这种会真正的执行一次
        when(list2.numAdd(1, 2)).thenReturn(100);
        assertEquals(100, list2.numAdd(1, 2));

        // 这种会避免真正执行
        doReturn(100).when(list2).numAdd(2, 3);
        assertEquals(100, list2.numAdd(2, 3));

        Mockito.verify(list2, times(2)).numAdd(1, 2);
        Mockito.verify(list2, times(1)).numAdd(2, 3);
    }

}
