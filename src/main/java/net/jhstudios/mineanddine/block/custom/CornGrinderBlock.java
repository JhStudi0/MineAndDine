package net.jhstudios.mineanddine.block.custom;

import net.jhstudios.mineanddine.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class CornGrinderBlock extends Block {

    public CornGrinderBlock(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                            PlayerEntity player, BlockHitResult hit)
    {
        System.out.println("CornGrinderBlock onUse");
        ItemStack held = player.getMainHandStack();

        if(held.isEmpty()){
            return ActionResult.PASS;
        }

        System.out.println("Held: " + held.getItem());
        System.out.println("Is wheat? " + (held.getItem() == Items.WHEAT));
        Item output = getGrindingResult(held.getItem());
        System.out.println("Output: " + output);
        if(output == null){
            return ActionResult.PASS;
        }

        if (!world.isClient){
            if (!player.isCreative()) {
                held.decrement(1);
            }

            ItemStack result = new ItemStack(output);
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 1.1;
            double z = pos.getZ() + 0.5;

            ItemEntity droppedItem = new ItemEntity(world, x, y, z, result);
            droppedItem.setVelocity(
                    world.random.nextDouble() * 0.2 - 0.1,
                    0.15,
                    world.random.nextDouble() * 0.2 - 0.1
            );
            world.spawnEntity(droppedItem);
        }
        world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE,
                SoundCategory.BLOCKS, 0.8f, 0.9f);

        return ActionResult.SUCCESS;

    }

    private static final Map<Item, Item> GRINDING_RECIPES = new HashMap<>();

    public static void registerRecipes(){
        GRINDING_RECIPES.put(Items.WHEAT, ModItems.FLOUR);
        GRINDING_RECIPES.put(Items.SUGAR_CANE, Items.SUGAR);
    }


    private Item getGrindingResult(Item input){
        return GRINDING_RECIPES.get(input);
    }


}
