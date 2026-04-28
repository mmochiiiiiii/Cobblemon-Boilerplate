package com.yourname.yourmod.network;

import com.yourname.yourmod.ExampleMod;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ExamplePayload(String message) implements CustomPacketPayload {

    // Define the unique ID for this payload type
    public static final Type<ExamplePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "example_packet"));

    // Define the StreamCodec to encode and decode the data automatically
    public static final StreamCodec<RegistryFriendlyByteBuf, ExamplePayload> CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, ExamplePayload::message,
            ExamplePayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}