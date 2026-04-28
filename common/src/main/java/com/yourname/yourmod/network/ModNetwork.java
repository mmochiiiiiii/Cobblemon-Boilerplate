package com.yourname.yourmod.network;

import com.yourname.yourmod.ExampleMod;
import dev.architectury.networking.NetworkManager;
import net.minecraft.server.level.ServerPlayer;

public class ModNetwork {

    public static void register() {
        // Register the payload type and its codec on the SERVER side
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, ExamplePayload.TYPE, ExamplePayload.CODEC, (payload, context) -> {

            // Execute logic on the main server thread
            context.queue(() -> {
                ServerPlayer player = (ServerPlayer) context.getPlayer();

                // Read the message directly from the payload object
                ExampleMod.LOGGER.info("Received packet from {}: {}", player.getName().getString(), payload.message());

                // Example action: Heal the player as a response to the packet
                player.heal(20.0f);
            });
        });
    }

    /**
     * Helper method to be called from Client-side code (e.g., Keybind press).
     * DO NOT call this from Server code.
     */
    public static void sendExamplePacketToServer(String message) {
        // Simply pass a new instance of your payload to the network manager!
        NetworkManager.sendToServer(new ExamplePayload(message));
    }
}