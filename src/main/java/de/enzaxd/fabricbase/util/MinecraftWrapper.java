package de.enzaxd.fabricbase.util;

import net.minecraft.client.MinecraftClient;

public class MinecraftWrapper {

    public static MinecraftClient game() {
        return MinecraftClient.getInstance();
    }
}
