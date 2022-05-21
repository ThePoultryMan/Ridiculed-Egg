package io.github.thepoultryman.regg.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class XpDamageMixin extends LivingEntity {
    protected XpDamageMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Inject(at = @At("HEAD"), method = "addExperience")
    public void regg$hurtPlayerOnAddition(int experience, CallbackInfo ci) {
        if (random.nextInt(5) == 0)
            damage(DamageSource.MAGIC, experience);
    }
}
