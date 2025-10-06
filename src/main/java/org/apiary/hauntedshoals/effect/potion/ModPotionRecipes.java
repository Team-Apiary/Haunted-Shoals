package org.apiary.hauntedshoals.effect.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;

public class ModPotionRecipes {
    public static void recipeRegister() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.SLOW_FALLING,
                    Items.FERMENTED_SPIDER_EYE,
                    ModPotions.HAUNTED_POTION
            );
            builder.registerPotionRecipe(
                    ModPotions.HAUNTED_POTION,
                    Items.REDSTONE,
                    ModPotions.LONG_HAUNTED_POTION
            );
        });
    }
}
