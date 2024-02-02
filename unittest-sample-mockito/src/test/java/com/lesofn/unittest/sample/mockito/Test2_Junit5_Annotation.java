package com.lesofn.unittest.sample.mockito;

import com.lesofn.unittest.sample.testable.MyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

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
public class Test2_Junit5_Annotation {

    /**
     * 要mock的对象
     */
    @Mock
    private List<String> list;

    /**
     * 把Mock对象注入的对象
     * 待测试对象
     */
    @InjectMocks
    private MyService myService;

    @Test
    void hello() {
        // 构建mock数据
        list.add("1");
        list.add("2");

        // 会得到null ，前面只是在记录行为而已，没有往list中添加数据
        assertNull(list.get(0));

        verify(list).add("1"); // 正确，因为该行为被记住了
    }


    @Test
    public void test2() {
        myService.add("5");
        verify(list).add("5");
    }

}
