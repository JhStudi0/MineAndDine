package net.jhstudios.mineanddine.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.screen.custom.CookingPotScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<CookingPotScreenHandler> COOKING_POT_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MineAndDine.MOD_ID, "cooking_pot_screen_handler"),
            new ExtendedScreenHandlerType<>(CookingPotScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers(){
        MineAndDine.LOGGER.info("Registering Screen Handlers for " + MineAndDine.MOD_ID);
    }
}
