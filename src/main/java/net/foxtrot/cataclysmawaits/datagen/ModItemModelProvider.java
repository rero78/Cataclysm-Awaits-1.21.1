package net.foxtrot.cataclysmawaits.datagen;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CataclysmAwaits.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.GIL.get());
        basicItem(ModItems.SIL.get());
        basicItem(ModItems.GLAPPLE.get());
        basicItem(ModItems.FRIEDMUSHLETCAPCAP.get());
        basicItem(ModItems.CATACLYSTFUEL.get());
        basicItem(ModItems.THEHORROR.get());
        basicItem(ModItems.THE_SPOON.get());
        basicItem(ModItems.MUSHROGLYCERIN.get());

        basicItem(ModItems.GLOG_ITEM.get());
        basicItem(ModItems.FROX_ITEM.get());
        basicItem(ModItems.PROG_ITEM.get());
        basicItem(ModItems.DROG_ITEM.get());
        basicItem(ModItems.SOG_ITEM.get());
        basicItem(ModItems.MOG_ITEM.get());
        basicItem(ModItems.XROG_ITEM.get());
        basicItem(ModItems.SKROG_ITEM.get());

        withExistingParent(ModItems.MUSHLET_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.MUSHBOOM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
