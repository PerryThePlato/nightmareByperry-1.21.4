package net.perrytheplato.nightmare.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.perrytheplato.nightmare.NightmareMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.entity.ModEntities;

public class ModItems {
    public static final Item MAGNETITE = registerItem("magnetite", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NightmareMod.MOD_ID,"magnetite")))));
    public static final Item RAW_MAGNETITE = registerItem("raw_magnetite", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NightmareMod.MOD_ID,"raw_magnetite")))));
    public static final Item NIGHTMARE_SMITHING_TEMPLATE = registerItem("nightmare_armor_trim_smithing_template",
            SmithingTemplateItem.of(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NightmareMod.MOD_ID, "nightmare_armor_trim_smithing_template")))));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NightmareMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NightmareMod.LOGGER.info("Registering Mod Items for " + NightmareMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MAGNETITE);
            entries.add(RAW_MAGNETITE);
            entries.add(NIGHTMARE_SMITHING_TEMPLATE);
        });



    }
}