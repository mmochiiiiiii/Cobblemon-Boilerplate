package com.yourname.yourmod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.yourname.yourmod.ExampleMod;
import com.yourname.yourmod.config.ModConfig;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class ModCommands {

    public static void register() {
        CommandRegistrationEvent.EVENT.register(ModCommands::registerCommands);
    }

    private static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext context, Commands.CommandSelection selection) {
        dispatcher.register(Commands.literal(ExampleMod.MOD_ID)
                .requires(source -> source.hasPermission(2)) // Require OP level 2
                .then(Commands.literal("reload")
                        .executes(cmd -> {
                            // Reload the config when the command is run
                            ModConfig.load();
                            cmd.getSource().sendSuccess(() -> Component.literal("Configuration reloaded successfully!"), true);
                            return 1;
                        }))
        );
    }
}