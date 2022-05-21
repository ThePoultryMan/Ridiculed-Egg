package io.github.thepoultryman.regg.mixin;

import io.github.thepoultryman.regg.ReggDamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrbEntity.class)
public abstract class XpDamageMixin extends Entity {
    public XpDamageMixin(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "onPlayerCollision", at = @At("HEAD"))
    private void regg$hurtPlayerOnAddition(PlayerEntity player, CallbackInfo ci) {
        if (!this.world.isClient && this.random.nextInt(5) == 0)
            player.damage(ReggDamageSource.experienceOrb(this), 3f);
    }
}
