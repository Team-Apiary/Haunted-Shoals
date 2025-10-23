package org.apiary.hauntedshoals.data;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;
import org.jetbrains.annotations.Nullable;

public class ModDataPacks {

    public static void registerDataPacks() {
        ModCommonInit.LOGGER.info("Registering Data Packs for Haunted Shoals");

        // The datapack folder is at: resources/resourcepacks/datapacks/
        // requiredModId is optional, set to null for no conditional registering
        registerBuiltinDatapack("compat_world_preview", true, "world_preview");
        registerBuiltinDatapack("compat_musketmod", true, "musketmod");
    }

    private static final ModContainer modContainer = FabricLoader.getInstance()
            .getModContainer(ModCommonInit.MOD_ID)
            .orElseThrow(() -> new IllegalStateException("Mod container not found for " + ModCommonInit.MOD_ID));


    public static void registerBuiltinDatapack(String datapackName, boolean autoEnable, @Nullable String requiredModId) {
        String fullPath = "datapacks/" + datapackName;
        boolean shouldAutoEnable = autoEnable;

        if (requiredModId != null) {
            if (FabricLoader.getInstance().isModLoaded(requiredModId)) {
                if (autoEnable) {
                    ModCommonInit.LOGGER.info("{} DETECTED - Registering datapack '{}' and auto-enabling it",
                            requiredModId.toUpperCase(), datapackName);
                } else {
                    ModCommonInit.LOGGER.info("{} DETECTED - Registering datapack '{}' But not auto-enabling it",
                            requiredModId.toUpperCase(), datapackName);
                }
            } else {
                ModCommonInit.LOGGER.info("Registering datapack '{}' But not auto-enabling it",
                        datapackName);
                shouldAutoEnable = false;
            }
        } else {
            ModCommonInit.LOGGER.info("Registering datapack '{}' with auto-enable set to {}",
                    datapackName, autoEnable);
        }

        ResourcePackActivationType activationType = shouldAutoEnable
                ? ResourcePackActivationType.DEFAULT_ENABLED
                : ResourcePackActivationType.NORMAL;

        Identifier datapackId = Identifier.of(ModCommonInit.MOD_ID, fullPath);
        ResourceManagerHelper.registerBuiltinResourcePack(datapackId, modContainer, activationType);
    }
}
