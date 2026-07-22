package net.jhstudios.mineanddine.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {

    public static final ItemGroup Mine_And_Dine_Item_Group = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MineAndDine.MOD_ID, "mine_and_dine_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CORN))
                    .displayName(Text.translatable("itemgroup.mineanddine.mine_and_dine_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.CORN);
                        entries.add(ModItems.CORN_SEEDS);
                        entries.add(ModItems.POPCORN);

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModItems.TOMATO_SAUCE);

                        entries.add(ModItems.VANILLA_BEAN);
                        entries.add(ModItems.VANILLA_SEEDS);

                        entries.add(ModItems.CHICKEN_LEG);

                        entries.add(ModItems.POPPY_SEEDS);

                        entries.add(ModItems.RICE_SEEDS);
                        entries.add(ModItems.RICE_BOWL);
                        entries.add(ModItems.SUSHI_COD);
                        entries.add(ModItems.SUSHI_SALMON);
                        entries.add(ModItems.ONIGIRI);

                        entries.add(ModItems.HONEY_COOKIE);

                        entries.add(ModItems.MILK_CHOCOLATE);
                        entries.add(ModItems.DARK_CHOCOLATE);
                        entries.add(ModItems.WHITE_CHOCOLATE);

                        entries.add(ModItems.CHOCOLATE_CAKE);

                        entries.add(ModItems.MILK_CHOCOLATE_APPLE);
                        entries.add(ModItems.DARK_CHOCOLATE_APPLE);
                        entries.add(ModItems.WHITE_CHOCOLATE_APPLE);

                        entries.add(ModItems.BUTTER);

                        entries.add(ModItems.SALT);
                        entries.add(ModItems.FLOUR);
                        entries.add(ModItems.YEAST_JAR);
                        entries.add(ModItems.FERMENTED_YEAST_JAR);
                        entries.add(ModItems.BREAD_DOUGH);

                        entries.add(ModItems.ROCK);

                        entries.add(ModItems.JAR);

                        entries.add(ModBlocks.COOKING_POT);
                        entries.add(ModBlocks.CORN_GRINDER);


                    }).build());



    public static void registerItemGroups() {
        MineAndDine.LOGGER.info("Registering Item Groups for " + MineAndDine.MOD_ID);
    }
}
