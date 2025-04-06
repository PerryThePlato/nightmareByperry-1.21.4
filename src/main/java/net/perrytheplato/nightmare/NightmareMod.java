package net.perrytheplato.nightmare;

import net.fabricmc.api.ModInitializer;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NightmareMod implements ModInitializer {
	public static final String MOD_ID = "nightmare-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}

	public static String getModId() {
		return MOD_ID;
	}
}