package com.lesofn.unittest.sample.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

/**
 * Mockito 5 with inline mocking capability for static methods
 *
 * @author sofn
 * @since 2025-04-22 23:20
 */
public class Test7_MockStatic {

    @Test
    void testMockStaticMethod() {
        UUID fixedUUID = UUID.fromString("e8c9f782-cec6-4173-8879-dddd916c4666");
        // Create a mockStatic for the UUID class
        try (MockedStatic<UUID> mockedUUID = mockStatic(UUID.class)) {
            // Define the behavior of the static method
            mockedUUID.when(UUID::randomUUID).thenReturn(fixedUUID);
            
            // Verify the mocked static method returns the fixed UUID
            UUID result = UUID.randomUUID();
            assertEquals(fixedUUID, result);
            assertEquals("e8c9f782-cec6-4173-8879-dddd916c4666", result.toString());
            
            // Verify the mock was called exactly once
            mockedUUID.verify(UUID::randomUUID);
        }
    }
    
    @Test
    void testMockMultipleStaticMethods() {
        LocalDate fixedDate = LocalDate.of(2025, 4, 22);
        LocalDate customDate = LocalDate.of(2030, 1, 1);

        // Create a mockStatic for the LocalDate class
        try (MockedStatic<LocalDate> mockedLocalDate = mockStatic(LocalDate.class)) {
            // Set fixed date for now() method
            mockedLocalDate.when(LocalDate::now).thenReturn(fixedDate);
            

            // Test mocked now() method
            LocalDate today = LocalDate.now();
            assertEquals(2025, today.getYear());
            assertEquals(4, today.getMonthValue());
            assertEquals(22, today.getDayOfMonth());

            // Set behavior for of() method with specific arguments
            mockedLocalDate.when(() -> LocalDate.of(2030, 1, 1)).thenReturn(customDate);

            // Test mocked of() method
            LocalDate futureDate = LocalDate.of(2030, 1, 1);
            assertEquals(customDate, futureDate);
        }
    }
}
