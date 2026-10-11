package mn.edu.ecom.util;

import java.time.Instant;

// Enum Singleton: thread-safe, reflection/serialization-д аюулгүй, төлөвгүй (read-only)
public enum SystemClock {
    INSTANCE;

    public Instant now() { return Instant.now(); }
    public long epochMillis() { return System.currentTimeMillis(); }
}
