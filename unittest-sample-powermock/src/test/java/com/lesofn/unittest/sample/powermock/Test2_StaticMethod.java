package com.lesofn.unittest.sample.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;


/**
 * @author sofn
 * @date 2022-05-18 11:36
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(System.class)
public class Test2_StaticMethod {

    @Test
    public void testGetLogFileWithException() {
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getenv(ArgumentMatchers.any())).thenReturn("./");
        assertEquals("./", System.getenv("test"));
    }
}
