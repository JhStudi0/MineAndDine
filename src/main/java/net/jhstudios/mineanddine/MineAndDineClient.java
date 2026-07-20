package net.jhstudios.mineanddine;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.entity.ModEntities;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class MineAndDineClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("===== MINE AND DINE CLIENT INITIALIZED =====");

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VANILLA_BEAN_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.ROCK, FlyingItemEntityRenderer::new);
    }
}
