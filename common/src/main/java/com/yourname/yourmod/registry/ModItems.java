package com.yourname.yourmod.registry;

import com.yourname.yourmod.ExampleMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ModItems {
    // Create the Deferred Register for Items using your Mod ID
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ExampleMod.MOD_ID, Registries.ITEM);

    // Example Item: A custom Pokéball or crafting material
    public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties().arch$tab(ExampleMod.EXAMPLE_TAB)));

    // Call this method in your Common setup class
    public static void init() {
        ITEMS.register();
    }
}