package net.perrytheplato.nightmare.trim;

import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern>  NIGHTMARE = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(NightmareMod.MOD_ID, "nightmare"));




}