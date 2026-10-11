package mn.edu.ecom.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class SystemClockTest {

    @Test
    @DisplayName("SystemClock guarantees single JVM identity (== comparison)")
    void identitySeam() {
        SystemClock ref1 = SystemClock.INSTANCE;
        SystemClock ref2 = SystemClock.valueOf("INSTANCE");
        assertSame(ref1, ref2, "Must be the exact same instance");
    }

    @Test
    @DisplayName("now() is read-only and moves forward")
    void nowIsMonotonic() {
        Instant a = SystemClock.INSTANCE.now();
        Instant b = SystemClock.INSTANCE.now();
        assertFalse(b.isBefore(a));
        assertTrue(SystemClock.INSTANCE.epochMillis() > 0);
    }
}
