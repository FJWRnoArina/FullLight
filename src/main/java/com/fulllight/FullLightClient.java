package com.fulllight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class FullLightClient implements ClientModInitializer {
    private static final double MAX_GAMMA = 15.0D;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(this::enforceMaximumGamma);
    }

    private void enforceMaximumGamma(MinecraftClient client) {
        if (client.options == null) {
            return;
        }

        double currentGamma = client.options.getGamma().getValue();
        if (currentGamma != MAX_GAMMA) {
            client.options.getGamma().setValue(MAX_GAMMA);
        }
    }
}
