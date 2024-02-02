package com.lesofn.unittest.sample.mockito;

import com.lesofn.unittest.sample.testable.MyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * 类上的注解相当于：
 *
 * @author sofn
 * @BeforeEach public void before() {
 * MockitoAnnotations.openMocks(this);
 * }
 * @date 2022-05-17 20:02
 */
@ExtendWith(MockitoExtension.class)
public class Test3_Stub {

    /**
     * 要mock的对象
     */
    @Mock
    private List<Integer> list;

    /**
     * when...thenReturn...
     * given...willReturn...
     */
    @Test
    void testStub() {
        when(list.get(0)).thenReturn(10);
        assertEquals(list.get(0), 10);
        assertNull(list.get(4));

        given(list.get(anyInt())).willReturn(100);
        assertEquals(list.get(4), 100);
    }

    /**
     * when...thenThrow...
     */
    @Test
    void testStub2() {
        when(list.get(2)).thenThrow(new RuntimeException("no such element"));
        assertThrows(RuntimeException.class, () -> list.get(2));
    }

    /**
     * when...then...
     */
    @Test
    void testStub3() {
        when(list.get(2)).then(invocationOnMock -> {
            System.out.println("可以获取上下文:" + invocationOnMock.getArguments()[0]);
            return 10;
        });
        assertEquals(list.get(2), 10);
    }

    /**
     * doReturn(...).when(..).function();
     */
    @Test
    void testStub4() {
        doReturn(10).when(list).get(0);
        assertEquals(list.get(0), 10);
        assertNull(list.get(4));
    }

    /**
     * doCallRealMethod不能用于Mock对象，只能用于Spy对象
     * 用于重置spy
     * when...thenCallRealMethod...
     */
    @Test
    void testStub5() {
        MyService exampleService = spy(new MyService());

        // spy 对象方法调用会用真实方法，所以这里返回 3
        assertEquals(3, exampleService.numAdd(1, 2));

        // 设置让 add(1,2) 返回 100
        when(exampleService.numAdd(1, 2)).thenReturn(100);
        when(exampleService.numAdd(2, 2)).thenReturn(100);
        assertEquals(100, exampleService.numAdd(1, 2));
        assertEquals(100, exampleService.numAdd(2, 2));

        // 重置 spy 对象，让 add(1,2) 调用真实方法，返回 3
        when(exampleService.numAdd(1, 2)).thenCallRealMethod();
        assertEquals(3, exampleService.numAdd(1, 2));

        // add(2, 2) 还是返回 100
        assertEquals(100, exampleService.numAdd(2, 2));
    }

}
