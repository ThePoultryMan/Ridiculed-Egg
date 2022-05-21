package io.github.thepoultryman.regg.mixin;

import io.github.thepoultryman.regg.RidiculedEgg;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class FoodHealingMixin {
    @Shadow public abstract void heal(float amount);

    @Inject(method = "eatFood", at = @At("RETURN"))
    private void regg$healWhenEaten(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        if (stack.isFood()) {
            this.heal(stack.getItem().getFoodComponent().getHunger() / 3f);
        }
    }
}
