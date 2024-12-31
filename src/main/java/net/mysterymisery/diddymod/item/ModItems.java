package net.mysterymisery.diddymod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mysterymisery.diddymod.TutorialMod;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    //Copy this line for each new item
    //LUBE
    public static final RegistryObject<Item> LUBE = ITEMS.register("lube",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEBONBON_SHARD = ITEMS.register("lebonbon_shard",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
