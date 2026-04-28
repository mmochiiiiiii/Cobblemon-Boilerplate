package com.yourname.yourmod;

import com.yourname.yourmod.command.ModCommands;
import com.yourname.yourmod.config.ModConfig;
import com.yourname.yourmod.event.ModEvents;
import com.yourname.yourmod.network.ModNetwork;
import com.yourname.yourmod.registry.ModItems;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ExampleMod {
    public static final String MOD_ID = "example_mod";

    // Standard SLF4J Logger for console output
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Register a custom Creative Mode Tab for the mod
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> EXAMPLE_TAB = TABS.register("example_tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".example_tab"),
                    () -> new ItemStack(ModItems.EXAMPLE_ITEM.get())
            )
    );

    public static void init() {
        // Load configuration first, so other systems can use the values
        ModConfig.load();

        // Initialize registries (Items, Blocks, Tabs)
        TABS.register();
        ModItems.init();

        // Register Events, Commands, and Networking
        ModEvents.register();
        ModCommands.register();
        ModNetwork.register();

        LOGGER.info("Successfully initialized common setup for {} with max Pokemon level: {}", MOD_ID, ModConfig.data.maxPokemonLevel);
    }
}