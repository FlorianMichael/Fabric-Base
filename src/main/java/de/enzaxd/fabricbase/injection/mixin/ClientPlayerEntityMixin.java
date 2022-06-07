package de.enzaxd.fabricbase.injection.mixin;

import de.enzaxd.fabricbase.event.PlayerUpdateEvent;
import net.lenni0451.asmevents.EventManager;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    public void injectTickHead(CallbackInfo ci) {
        EventManager.call(new PlayerUpdateEvent(PlayerUpdateEvent.Type.PRE));
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void injectTickReturn(CallbackInfo ci) {
        EventManager.call(new PlayerUpdateEvent(PlayerUpdateEvent.Type.POST));
    }
}
