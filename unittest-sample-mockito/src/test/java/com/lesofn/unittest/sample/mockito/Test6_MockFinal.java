package com.lesofn.unittest.sample.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Mockito 5 with inline mocking capability for final classes
 *
 * @author sofn
 * @since 2025-04-22 23:15
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class Test6_MockFinal {

    /**
     * LocalDate is a final class but can be mocked with mockito-inline
     */
    @Mock
    private LocalDate localDate;

    @Test
    void testMockFinalClass() {
        // Set up the mock behavior
        when(localDate.getYear()).thenReturn(2025);
        when(localDate.getMonthValue()).thenReturn(4);
        when(localDate.getDayOfMonth()).thenReturn(22);

        // Verify the mocked behavior works
        assertEquals(2025, localDate.getYear());
        assertEquals(4, localDate.getMonthValue());
        assertEquals(22, localDate.getDayOfMonth());
        
        // Format as string using the mocked values
        String dateStr = String.format("%d-%02d-%02d", 
                localDate.getYear(), 
                localDate.getMonthValue(), 
                localDate.getDayOfMonth());
        
        assertEquals("2025-04-22", dateStr);
    }
}
