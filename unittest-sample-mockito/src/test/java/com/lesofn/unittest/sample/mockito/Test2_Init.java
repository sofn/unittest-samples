package com.lesofn.unittest.sample.mockito;

import com.lesofn.unittest.sample.testable.MyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

/**
 * Simplify the Mock creation method. You can use field annotations
 *
 * @author sofn
 * @since 2022-05-17 20:02
 */
public class Test2_Init {

    /**
     * need mock data
     */
    @Mock
    private List<String> list;

    /**
     * The object into which the Mock object is injected, to be tested
     * Inject the mock object according to the type
     */
    @InjectMocks
    private MyService myService;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void hello() {
        // build mock data
        list.add("1");
        list.add("2");

        // will get null. The previous step is just recording the behavior, and no data is added to the list.
        assertNull(list.get(0));

        verify(list).add("1"); // correct, because the behavior is remembered
    }

    @Test
    public void test2() {
        myService.add("5");
        verify(list).add("5");
    }

}
