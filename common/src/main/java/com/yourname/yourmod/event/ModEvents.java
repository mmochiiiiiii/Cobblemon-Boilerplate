package com.yourname.yourmod.event;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.yourname.yourmod.ExampleMod;
import kotlin.Unit;
import net.minecraft.world.entity.player.Player;

public class ModEvents {

    public static void register() {
        // Example: Listen for when a player successfully captures a Pokémon
        CobblemonEvents.POKEMON_CAPTURED.subscribe(Priority.NORMAL, event -> {
            Player player = event.getPlayer();
            String pokemonName = event.getPokemon().getSpecies().getName();

            // Log the capture to the console
            ExampleMod.LOGGER.info("{} just caught a {}!", player.getName().getString(), pokemonName);

            // Because Cobblemon uses Kotlin, we must return Unit.INSTANCE
            return Unit.INSTANCE;
        });

        // Example: Listen for AFTER a Pokémon is successfully sent out of its Pokéball
        CobblemonEvents.POKEMON_SENT_POST.subscribe(Priority.NORMAL, event -> {
            ExampleMod.LOGGER.info("A {} was sent out into the world!", event.getPokemon().getSpecies().getName());

            return Unit.INSTANCE;
        });
    }
}