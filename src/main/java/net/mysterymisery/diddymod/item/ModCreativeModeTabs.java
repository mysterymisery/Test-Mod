package net.mysterymisery.diddymod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mysterymisery.diddymod.TutorialMod;
import net.mysterymisery.diddymod.block.ModBlocks;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DIDDY_ITEMS_TAB = CREATIVE_MODE_TABS.register("diddy_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.LUBE.get()))
                    .title(Component.translatable("creativetab.diddymod.diddy_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                            output.accept(ModItems.LUBE.get());
                            output.accept(ModItems.LEBONBON_SHARD.get());
                            output.accept(ModItems.CHISEL.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> DIDDY_BLOCKS_TAB = CREATIVE_MODE_TABS.register("diddy_blocks_tab",
            () -> CreativeModeTab.builder()
                    //WITH TABS METHOD IS USED TO ORDER THE TABS IN A PARTICULAR WAY
                    .withTabsBefore(DIDDY_ITEMS_TAB.getId())
                    .icon(() -> new ItemStack(ModBlocks.LUBE_BLOCK.get()))
                    .title(Component.translatable("creativetab.diddymod.diddy_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.LUBE_BLOCK.get());
                        output.accept(ModBlocks.DIDDY_ORE.get());
                        output.accept(ModBlocks.DIDDY_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> DIDDY_FOOD_TAB = CREATIVE_MODE_TABS.register("diddy_food_tab",
            () -> CreativeModeTab.builder()
                    //WITH TABS METHOD IS USED TO ORDER THE TABS IN A PARTICULAR WAY
                    .withTabsBefore(DIDDY_ITEMS_TAB.getId())
                    .icon(() -> new ItemStack(ModItems.CRAB_RANGOON.get()))
                    .title(Component.translatable("creativetab.diddymod.diddy_food"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CRAB_RANGOON.get());
                        output.accept(ModItems.DIDDY_DAIQUIRI.get());
                    })
                    .build());



    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
