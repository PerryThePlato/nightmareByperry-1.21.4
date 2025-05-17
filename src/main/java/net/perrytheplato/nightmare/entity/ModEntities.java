package net.perrytheplato.nightmare.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.LurkerEntity;

public class ModEntities {

    public static final RegistryKey<EntityType<?>> LURKER_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "lurker")
    );

    public static final EntityType<LurkerEntity> LURKER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "lurker"),
            EntityType.Builder.create(LurkerEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.7f, .725f).build(LURKER_KEY));


    public static void registerModEntities() {
        NightmareMod.LOGGER.info("Registering Mod Entities for " + NightmareMod.MOD_ID);
    }
}
