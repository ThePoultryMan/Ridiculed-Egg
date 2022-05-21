package io.github.thepoultryman.regg;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;

public class ReggDamageSource extends DamageSource {
    public static DamageSource experienceOrb(Entity orb) {
        return new EntityDamageSource("experienceOrb", orb);
    }

    protected ReggDamageSource(String string) {
        super(string);
    }
}
