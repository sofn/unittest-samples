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
 * @since 2022-05-17 20:02
 */
@ExtendWith(MockitoExtension.class)
public class Test2_Junit5_Annotation {

    /**
     * the object to mock
     */
    @Mock
    private List<String> list;

    /**
     * The object into which the Mock object is injected
     * The object to be tested
     */
    @InjectMocks
    private MyService myService;

    @Test
    void hello() {
        // build mock data
        list.add("1");
        list.add("2");

        // will get null. The previous step is just recording the behavior, and no data is added to the list.
        assertNull(list.get(0));

        verify(list).add("1"); //correct, because the behavior is remembered
    }


    @Test
    public void test2() {
        myService.add("5");
        verify(list).add("5");
    }

}
