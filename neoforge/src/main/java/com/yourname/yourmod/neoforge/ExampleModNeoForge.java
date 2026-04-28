package com.yourname.yourmod.neoforge;

import com.yourname.yourmod.ExampleMod;
import net.neoforged.fml.common.Mod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
