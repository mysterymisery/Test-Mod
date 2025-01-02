package net.mysterymisery.diddymod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.mysterymisery.diddymod.TutorialMod;
import net.mysterymisery.diddymod.block.ModBlocks;
import net.mysterymisery.diddymod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        List<ItemLike> MITHRIL_SMELTABLES = List.of(ModItems.MITHRIL.get(),
            ModBlocks.MITHRIL_ORE.get(), ModBlocks.MITHRIL_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LUBE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.LUBE.get())
                .unlockedBy(getHasName(ModItems.LUBE.get()), has(ModItems.LUBE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLAZE_ROD_BUNDLE.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', Items.BLAZE_ROD)
                .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LUBE.get(), 9)
                .requires(ModBlocks.LUBE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LUBE_BLOCK.get()), has(ModBlocks.LUBE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLAZE_ROD, 4)
                .requires(ModItems.BLAZE_ROD_BUNDLE.get())
                .unlockedBy(getHasName(ModItems.BLAZE_ROD_BUNDLE.get()), has(ModItems.BLAZE_ROD_BUNDLE.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL.get(),
                0.25f, 200, "mithril");
        oreBlasting(pRecipeOutput, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL.get(),
                0.25f, 100, "mithril");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
