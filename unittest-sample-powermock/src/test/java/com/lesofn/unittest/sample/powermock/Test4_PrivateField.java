package com.lesofn.unittest.sample.powermock;

import com.lesofn.unittest.sample.testable.PowerMockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

/**
 * @author sofn
 * @since 2022-05-18 11:36
 */
@RunWith(PowerMockRunner.class)
public class Test4_PrivateField {

    @Spy
    private PowerMockService powerMockService = new PowerMockService();

    @Test
    public void testPrivateField() throws Exception {
        Whitebox.setInternalState(powerMockService, "num", 10);
        assertEquals(10, powerMockService.getNum());
    }
}
