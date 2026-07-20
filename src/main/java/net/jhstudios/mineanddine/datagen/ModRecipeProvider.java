package net.jhstudios.mineanddine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> CORN_SMELTABLES = List.of(ModItems.CORN_SEEDS);

        offerSmelting(exporter, CORN_SMELTABLES, RecipeCategory.FOOD, ModItems.POPCORN, 0.25f, 100, "corn");

        List<ItemConvertible> BREAD_DOUGH = List.of(ModItems.BREAD_DOUGH);

        offerSmelting(exporter, BREAD_DOUGH, RecipeCategory.FOOD, Items.BREAD, 0.25f, 400, "bread_dough");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CORN_SEEDS, 2)
                .input(ModItems.CORN)
                .criterion(hasItem(ModItems.CORN), conditionsFromItem(ModItems.CORN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TOMATO_SEEDS, 2)
                .input(ModItems.TOMATO)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TOMATO_SAUCE, 1)
                .input(ModItems.TOMATO, 2)
                .input(Items.BOWL)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROCK, 4)
                .input(Items.COBBLESTONE)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.VANILLA_SEEDS, 1)
                .input(ModItems.VANILLA_BEAN)
                .criterion(hasItem(ModItems.VANILLA_BEAN), conditionsFromItem(ModItems.VANILLA_BEAN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.HONEY_COOKIE, 8)
                .input(ModItems.VANILLA_BEAN)
                .input(Items.HONEY_BOTTLE)
                .input(Items.WHEAT)
                .input(Items.EGG)
                .input(ModItems.SALT)
                .input(ModItems.BUTTER)
                .input(Items.SUGAR)
                .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MILK_CHOCOLATE, 3)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.DARK_CHOCOLATE, 3)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WHITE_CHOCOLATE, 3)
                .input(Items.SUGAR)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MILK_CHOCOLATE_APPLE,1)
                .input(Items.APPLE)
                .input(ModItems.MILK_CHOCOLATE)
                .criterion(hasItem(ModItems.MILK_CHOCOLATE), conditionsFromItem(ModItems.MILK_CHOCOLATE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.DARK_CHOCOLATE_APPLE,1)
                .input(Items.APPLE)
                .input(ModItems.DARK_CHOCOLATE)
                .criterion(hasItem(ModItems.DARK_CHOCOLATE), conditionsFromItem(ModItems.DARK_CHOCOLATE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WHITE_CHOCOLATE_APPLE,1)
                .input(Items.APPLE)
                .input(ModItems.WHITE_CHOCOLATE)
                .criterion(hasItem(ModItems.WHITE_CHOCOLATE), conditionsFromItem(ModItems.WHITE_CHOCOLATE))
                .offerTo(exporter);




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POPPY_SEEDS, 4)
                .pattern("RR ")
                .pattern("RR ")
                .pattern("   ")
                .input('R', Items.POPPY)
                .criterion(hasItem(Items.POPPY), conditionsFromItem(Items.POPPY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE)
                .pattern("RR ")
                .pattern("RR ")
                .pattern("   ")
                .input('R', ModItems.ROCK)
                .criterion(hasItem(ModItems.ROCK), conditionsFromItem(ModItems.ROCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHOCOLATE_CAKE)
                .pattern("MMM")
                .pattern("SES")
                .pattern("WCW")
                .input('M', ModItems.MILK_CHOCOLATE)
                .input('S', Items.SUGAR)
                .input('E', Items.EGG)
                .input('W', Items.WHEAT)
                .input('C', Items.COCOA_BEANS)
                .criterion(hasItem(ModItems.MILK_CHOCOLATE), conditionsFromItem(ModItems.MILK_CHOCOLATE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JAR, 3)
                .pattern(" B ")
                .pattern("G G")
                .pattern(" G ")
                .input('B', ItemTags.BUTTONS)
                .input('G', Items.GLASS)
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .offerTo(exporter);
    }
}
