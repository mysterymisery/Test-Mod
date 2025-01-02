package net.mysterymisery.diddymod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mysterymisery.diddymod.TutorialMod;
import net.mysterymisery.diddymod.block.custom.LubeBlock;
import net.mysterymisery.diddymod.block.custom.MagicBlock;
import net.mysterymisery.diddymod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    // TO ADD NEW BLOCKS COPY THE CODE BELOW
    //LUBE BLOCK
    //IF YOU DONT WANT TO HAVE A LOOT TABLE USE THE .noLootTable() METHOD
    public static final RegistryObject<Block> LUBE_BLOCK = registerBlock("lube_block",
            () -> new LubeBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> DIDDY_ORE = registerBlock("diddy_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.SCULK_SENSOR)));
    public static final RegistryObject<Block> DIDDY_DEEPSLATE_ORE = registerBlock("diddy_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.SCULK_SENSOR)));
    public static final RegistryObject<Block> MITHRIL_ORE = registerBlock("mithril_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MITHRIL_DEEPSLATE_ORE = registerBlock("mithril_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
