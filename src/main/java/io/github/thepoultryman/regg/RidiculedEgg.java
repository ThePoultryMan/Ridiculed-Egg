package io.github.thepoultryman.regg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.advancement.CriterionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RidiculedEgg implements ModInitializer {
	public static final String MOD_ID = "regg";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Just ridiculing an egg...");
	}
}
