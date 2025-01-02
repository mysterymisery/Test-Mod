package net.mysterymisery.diddymod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mysterymisery.diddymod.TutorialMod;
import net.mysterymisery.diddymod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LUBE.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.CRAB_RANGOON.get());
        basicItem(ModItems.DIDDY_DAIQUIRI.get());
        basicItem(ModItems.BLAZE_ROD_BUNDLE.get());
        basicItem(ModItems.LEBONBON_SHARD.get());
        basicItem(ModItems.MITHRIL.get());
    }
}
