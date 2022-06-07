package de.enzaxd.fabricbase.injection.mixin;

import de.enzaxd.fabricbase.Bootstrap;
import de.enzaxd.fabricbase.event.WindowTitleEvent;
import net.lenni0451.asmevents.EventManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

    @Shadow
    protected abstract String getWindowTitle();

    @Inject(method = "<init>", at = @At("RETURN"))
    public void injectConstructor(RunArgs args, CallbackInfo ci) {
        Bootstrap.boot();
    }

    @Redirect(method = "updateWindowTitle", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;getWindowTitle()Ljava/lang/String;"))
    public String redirectUpdateWindowTitle(MinecraftClient instance) {
        final WindowTitleEvent windowTitleEvent = EventManager.call(new WindowTitleEvent(getWindowTitle()));
        return windowTitleEvent.getWindowTitle();
    }
}
