package net.foxtrot.cataclysmawaits.datagen;

import net.foxtrot.cataclysmawaits.block.ModBlocks;
import net.foxtrot.cataclysmawaits.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GIL_STACK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.GIL.get())
                .unlockedBy("has_gil", has(ModItems.GIL)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SIL_STACK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.SIL.get())
                .unlockedBy("has_sil", has(ModItems.SIL)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CATACLYSTFUEL.get())
                .pattern("TBT")
                .pattern("LSL")
                .pattern("TBT")
                .define('S',Items.NETHER_STAR)
                .define('L',Items.LAVA_BUCKET)
                .define('T',Items.TNT)
                .define('B',Items.BLAZE_ROD)
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TNT, 6)
                .pattern("SSS")
                .pattern("MMM")
                .pattern("SSS")
                .define('M',ModItems.MUSHROGLYCERIN.get())
                .define('S',Items.SAND)
                .unlockedBy("has_mushroglycerin", has(ModItems.MUSHROGLYCERIN)).save(recipeOutput);




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GIL.get(), 9)
                .requires(ModBlocks.GIL_STACK)
                .unlockedBy("has_gil_stack", has(ModBlocks.GIL_STACK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SIL.get(), 9)
                .requires(ModBlocks.SIL_STACK)
                .unlockedBy("has_gil_stack", has(ModBlocks.SIL_STACK)).save(recipeOutput);

    }
}
