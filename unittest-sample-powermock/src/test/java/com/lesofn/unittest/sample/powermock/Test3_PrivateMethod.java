package com.lesofn.unittest.sample.powermock;

import com.lesofn.unittest.sample.testable.PowerMockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author sofn
 * @date 2022-05-18 11:36
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PowerMockService.class})
public class Test3_PrivateMethod {

    @Spy
    private PowerMockService powerMockService = new PowerMockService();

    @Test
    public void testPrivateMethod() throws Exception {
        // mock私有方法
        PowerMockito.when(powerMockService, "isExists", "./").thenReturn(true);
        // mock没有返回值的私有方法
        PowerMockito.doNothing().when(powerMockService, "log", "./");

        // do
        powerMockService.pubIsExists("./");
        // verify
        assertTrue(powerMockService.pubIsExists("./"));
    }
}
