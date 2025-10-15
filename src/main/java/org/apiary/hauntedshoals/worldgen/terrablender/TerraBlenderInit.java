package org.apiary.hauntedshoals.worldgen.terrablender;

import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

//TODO Fix terrablender generation outside of dev

public class TerraBlenderInit implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized()
    {
        Regions.register(new ModOverworldRegion(Identifier.of(ModCommonInit.MOD_ID, "overworld"), 2));
    }
}
