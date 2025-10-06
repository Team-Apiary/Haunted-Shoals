package org.apiary.hauntedshoals.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.apiary.hauntedshoals.init.ModCommonInit;
import org.apiary.hauntedshoals.item.custom.CursedSeaglassItem;
import org.apiary.hauntedshoals.item.custom.CutlassItem;

public class ModItems {

    //CURSED SEAGLASS
    public static final Item CURSED_SEAGLASS = registerItem("cursed_seaglass", new CursedSeaglassItem(new Item.Settings().rarity(Rarity.UNCOMMON)));
    public static final Item CURSED_SEAGLASS_STAFF = registerItem("cursed_seaglass_staff", new Item(new Item.Settings().rarity(Rarity.UNCOMMON)));
    //CUTLASSES
    public static final Item WOOD_CUTLASS = registerItem("wood_cutlass", new CutlassItem(ToolMaterials.WOOD,
            new Item.Settings().attributeModifiers(CutlassItem.createAttributeModifiers(ToolMaterials.WOOD, 1.0f, -1.8f))));
    public static final Item STONE_CUTLASS = registerItem("stone_cutlass", new CutlassItem(ToolMaterials.STONE,
            new Item.Settings().attributeModifiers(CutlassItem.createAttributeModifiers(ToolMaterials.STONE, 1.0f, -1.8f))));
    public static final Item IRON_CUTLASS = registerItem("iron_cutlass", new CutlassItem(ToolMaterials.IRON,
            new Item.Settings().attributeModifiers(CutlassItem.createAttributeModifiers(ToolMaterials.IRON, 1.0f, -1.8f))));
    public static final Item GOLD_CUTLASS = registerItem("gold_cutlass", new CutlassItem(ToolMaterials.GOLD,
            new Item.Settings().attributeModifiers(CutlassItem.createAttributeModifiers(ToolMaterials.GOLD, 1.0f, -1.8f))));
    public static final Item DIAMOND_CUTLASS = registerItem("diamond_cutlass", new CutlassItem(ToolMaterials.DIAMOND,
            new Item.Settings().attributeModifiers(CutlassItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1.0f, -1.8f))));
    public static final Item NETHERITE_CUTLASS = registerItem("netherite_cutlass", new CutlassItem(ToolMaterials.NETHERITE,
            new Item.Settings().fireproof().attributeModifiers(CutlassItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1.0f, -1.8f))));

    //Register Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ModCommonInit.MOD_ID, name), item);
    }

    public static void registerModItems() {
        //ModCommonInit.LOGGER.info("Registering Mod Items for " + ModCommonInit.MOD_ID);
    }
}
