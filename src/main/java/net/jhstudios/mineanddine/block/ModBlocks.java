package net.jhstudios.mineanddine.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.block.custom.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CORN_CROP = registerBlockWithoutBlockItem("corn_crop",
            new CornCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.YELLOW)));

    public static final Block TOMATO_CROP = registerBlockWithoutBlockItem("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.RED)));

    public static final Block VANILLA_BEAN_CROP = registerBlockWithoutBlockItem("vanilla_bean_crop",
            new VanillaBeanCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.BROWN)));

    public static final Block RICE_CROP = registerBlockWithoutBlockItem("rice_crop",
            new RiceCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.GREEN)));


    public static final Block YEAST_JAR = registerBlockWithoutBlockItem("yeast_jar",
            new YeastJarBlock(AbstractBlock.Settings.create()
                    .ticksRandomly().sounds(BlockSoundGroup.GLASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.BROWN)
                    .nonOpaque()));


    public static final Block CHOCOLATE_CAKE = registerBlockWithoutBlockItem("chocolate_cake",
            new CakeBlock(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOL)
                    .nonOpaque()
            ));

    public static final Block COOKING_POT = registerBlock("cooking_pot",
            new CookingPotBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block PLATE = registerBlock("plate",
            new PlateBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block CORN_GRINDER = registerBlock("corn_grinder",
            new CornGrinderBlock(AbstractBlock.Settings.create().nonOpaque()));


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MineAndDine.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MineAndDine.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MineAndDine.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MineAndDine.LOGGER.info("Registering Mod Blocks for " + MineAndDine.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

        });
    }
}
