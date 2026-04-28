package com.yourname.yourmod.mixin;

import com.yourname.yourmod.ExampleMod;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @Inject(method = "init", at = @At("HEAD"))
    private void onInit(CallbackInfo ci) {
        // This will print to the console every time the main menu loads
        ExampleMod.LOGGER.info("Hello from Cobblemon Boilerplate Mixin!");
    }
}