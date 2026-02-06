package com.fulllight;

import com.fulllight.mixin.SimpleOptionAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.SimpleOption;

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

        SimpleOption<Double> gammaOption = client.options.getGamma();
        Double currentGamma = gammaOption.getValue();
        if (currentGamma == null || currentGamma != MAX_GAMMA) {
            ((SimpleOptionAccessor<Double>) gammaOption).fulllight$setValue(MAX_GAMMA);
        }
    }
}
