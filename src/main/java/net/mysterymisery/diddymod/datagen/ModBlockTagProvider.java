package net.mysterymisery.diddymod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mysterymisery.diddymod.TutorialMod;
import net.mysterymisery.diddymod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LUBE_BLOCK.get())
                .add(ModBlocks.DIDDY_DEEPSLATE_ORE.get())
                .add(ModBlocks.DIDDY_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LUBE_BLOCK.get())
                .add(ModBlocks.DIDDY_DEEPSLATE_ORE.get())
                .add(ModBlocks.DIDDY_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE.get())
                .add(ModBlocks.MITHRIL_DEEPSLATE_ORE.get());

    }
}
