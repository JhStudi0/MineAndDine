package net.jhstudios.mineanddine;

import net.fabricmc.api.ModInitializer;

import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.block.custom.CornGrinderBlock;
import net.jhstudios.mineanddine.block.entity.ModBlockEntities;
import net.jhstudios.mineanddine.entity.ModEntities;
import net.jhstudios.mineanddine.item.ModItemGroups;
import net.jhstudios.mineanddine.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineAndDine implements ModInitializer {
    public static final String MOD_ID = "mineanddine";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModEntities.registerModEntities();
        ModBlockEntities.registerBlockEntities();

        CornGrinderBlock.registerRecipes();
    }
}
