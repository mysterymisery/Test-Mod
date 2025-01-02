package net.mysterymisery.diddymod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.common.Mod;
import net.mysterymisery.diddymod.item.ModItems;
import net.mysterymisery.diddymod.sound.ModSounds;
import net.mysterymisery.diddymod.util.ModTags;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties){
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {


        pLevel.playSound(pPlayer, pPos, SoundEvents.SHULKER_AMBIENT, SoundSource.BLOCKS, 1f, 1f);
        //THIS RETURN MAKES THE HAND DO A MOTION
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity){
            if(isValidItem(itemEntity.getItem())){
                itemEntity.setItem(new ItemStack(ModItems.LEBONBON_SHARD.get(), itemEntity.getItem().getCount()));
                pLevel.playLocalSound(pPos, ModSounds.MAGIC_BLOCK_USE.get(),SoundSource.BLOCKS, 1f,1f, false);
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.diddymod.magic_block.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
