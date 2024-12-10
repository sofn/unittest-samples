package com.lesofn.unittest.sample.mockito;

import com.lesofn.unittest.sample.testable.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;

/**
 * add annotation: @RunWith equals:
 *
 * @BeforeEach public void before() {
 *      MockitoAnnotations.openMocks(this);
 * }
 *
 * <p>
 * Silent: by default, unused stubs in the test code will be detected to keep the code clean.
 *         This feature can be turned off by annotation (MockitoJUnitRunner.Silent.class)
 *
 * @author sofn
 * @since 2022-05-17 20:02
 */
// @RunWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class Test2_Junit4_Annotation {

    /**
     * the object to mock
     */
    @Mock
    private List<String> list;

    /**
     * The object into which the Mock object is injected
     */
    @InjectMocks
    private MyService myService;

    @Test
    public void hello() {
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
