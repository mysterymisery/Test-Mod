package net.mysterymisery.diddymod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mysterymisery.diddymod.TutorialMod;
import net.mysterymisery.diddymod.item.custom.ChiselItem;
import net.mysterymisery.diddymod.item.custom.DiddyDaiquiriItem;
import net.mysterymisery.diddymod.item.custom.FuelItem;

import java.util.List;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    //Copy this line for each new item
    //LUBE
    public static final RegistryObject<Item> LUBE = ITEMS.register("lube",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRIL = ITEMS.register("mithril",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEBONBON_SHARD = ITEMS.register("lebonbon_shard",
            () -> new Item(new Item.Properties()));

    public static  final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()
                    .durability(32)
            ));

    public static final RegistryObject<Item> CRAB_RANGOON = ITEMS.register("crab_rangoon",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CRAB_RANGOON)){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.diddymod.crab_rangoon"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> DIDDY_DAIQUIRI = ITEMS.register("diddy_daiquiri",
            () -> new DiddyDaiquiriItem(new Item.Properties().food(ModFoodProperties.DIDDY_DAIQUIRI)));

    public static final RegistryObject<Item> BLAZE_ROD_BUNDLE = ITEMS.register("blaze_rod_bundle",
            () -> new FuelItem(new Item.Properties(), 9700));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
