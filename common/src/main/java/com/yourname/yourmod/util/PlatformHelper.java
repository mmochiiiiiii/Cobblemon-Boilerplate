package com.yourname.yourmod.util;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class PlatformHelper {
    /**
     * This is an example of the Expect/Actual pattern.
     * The implementation will be provided by the specific platform modules (Fabric/NeoForge)
     * at compile time.
     */
    @ExpectPlatform
    public static String getPlatformName() {
        throw new AssertionError();
    }
}