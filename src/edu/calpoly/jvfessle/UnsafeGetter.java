package edu.calpoly.jvfessle;

public class UnsafeGetter {
	// COG=7
	// CYC=4
	@SuppressWarnings("restriction")
	private static sun.misc.Unsafe getUnsafe() {
        try {
          return sun.misc.Unsafe.getUnsafe();
        } catch (SecurityException e) {
          // that's okay; try reflection instead
        }
        try {
          return java.security.AccessController.doPrivileged(
              new java.security.PrivilegedExceptionAction<sun.misc.Unsafe>() {
                @Override
                public sun.misc.Unsafe run() throws Exception {
                  Class<sun.misc.Unsafe> k = sun.misc.Unsafe.class;
                  for (java.lang.reflect.Field f : k.getDeclaredFields()) {
                    f.setAccessible(true);
                    Object x = f.get(null);
                    if (k.isInstance(x)) {
                      return k.cast(x);
                    }
                  }
                  throw new NoSuchFieldError("the Unsafe");
                }
              });
        } catch (java.security.PrivilegedActionException e) {
          throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
}
}