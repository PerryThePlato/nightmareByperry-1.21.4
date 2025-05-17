package net.perrytheplato.nightmare;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.gen.GenerationStep;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.entity.ModEntities;
import net.perrytheplato.nightmare.entity.client.LurkerModel;
import net.perrytheplato.nightmare.entity.client.LurkerRenderer;
import net.perrytheplato.nightmare.entity.custom.LurkerEntity;
import net.perrytheplato.nightmare.item.ModItems;
import net.perrytheplato.nightmare.world.ModConfiguredFeatures;
import net.perrytheplato.nightmare.world.ModPlacedFeatures;
import net.perrytheplato.nightmare.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NightmareMod implements ModInitializer {
	public static final String MOD_ID = "nightmare-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.registerModEntities();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();


		FabricDefaultAttributeRegistry.register(ModEntities.LURKER, LurkerEntity.createAttributes());

		ModWorldGeneration.generateModWorldGen();

	}

	public static String getModId() {
		return MOD_ID;
	}
}