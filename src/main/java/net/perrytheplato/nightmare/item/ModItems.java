package net.perrytheplato.nightmare.item;



import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.perrytheplato.nightmare.NightmareMod;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;


public class ModItems {

    public static final Item MAGNETITE = registerItem(new Item.Settings());



    private static Item registerItem(Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NightmareMod.MOD_ID, "magnetite"));
        Item item = new Item(itemSettings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {

        NightmareMod.LOGGER.info("Registering Mod Items for " + NightmareMod.MOD_ID);



        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

            entries.add(MAGNETITE);

        });

    }


}