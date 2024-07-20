package com.example.examplemod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public class EntityMixin {
    @WrapOperation(method = "baseTick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;spawnSprintParticle()V"))
    private void onSpawnSprintParticle(Entity instance, Operation<Void> original) {
        if (instance instanceof Player) {
            for (int i = 0; i < 100; i++) {
                original.call(instance);
            }
        }
    }
}
