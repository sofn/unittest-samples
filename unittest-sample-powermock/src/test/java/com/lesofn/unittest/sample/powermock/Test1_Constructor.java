package com.lesofn.unittest.sample.powermock;

import com.lesofn.unittest.sample.testable.PowerMockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * 注意：
 * 1. @PrepareForTest({MyService2.class}) 要写的是要测试的类
 * 2. PowerMockito.whenNew 作用是mock到测试类中方法里new对象
 *
 * @author sofn
 * @date 2022-05-18 11:36
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PowerMockService.class})
public class Test1_Constructor {

    @InjectMocks
    PowerMockService powerMockService;

    @Test
    public void test() throws Exception {
        ArrayList<String> mockList = PowerMockito.mock(ArrayList.class);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

        PowerMockito.when(mockList.get(1)).thenReturn("100");

        assertEquals("100", powerMockService.get(1));
    }
}
