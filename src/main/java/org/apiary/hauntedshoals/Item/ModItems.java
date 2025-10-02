package org.apiary.hauntedshoals.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModItems {

    //Register Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ModCommonInit.MOD_ID, name), item);
    }

    public static void registerModItems() {
        //ModCommonInit.LOGGER.info("Registering Mod Items for " + ModCommonInit.MOD_ID);
    }
}
