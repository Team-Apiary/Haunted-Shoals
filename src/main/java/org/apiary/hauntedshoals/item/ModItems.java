package org.apiary.hauntedshoals.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModItems {

    public static final Item CURSED_SEAGLASS = registerItem("cursed_seaglass", new Item(new Item.Settings()));
    public static final Item CURSED_SEAGLASS_STAFF = registerItem("cursed_seaglass_staff", new Item(new Item.Settings()));
    public static final Item DIAMOND_CUTLASS = registerItem("diamond_cutlass", new Item(new Item.Settings()));

    //Register Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ModCommonInit.MOD_ID, name), item);
    }

    public static void registerModItems() {
        //ModCommonInit.LOGGER.info("Registering Mod Items for " + ModCommonInit.MOD_ID);
    }
}
