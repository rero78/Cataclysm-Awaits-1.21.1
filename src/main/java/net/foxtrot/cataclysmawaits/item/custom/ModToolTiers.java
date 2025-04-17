package net.foxtrot.cataclysmawaits.item.custom;

import net.foxtrot.cataclysmawaits.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier SPOON = new SimpleTier(ModTags.Blocks.NEEDS_SPOON,
            500, 0.25f, -2, 99, () -> Ingredient.of(Items.IRON_INGOT));
}
