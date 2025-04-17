package net.foxtrot.cataclysmawaits.item;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.block.ModBlocks;
import net.foxtrot.cataclysmawaits.entity.ModEntities;
import net.foxtrot.cataclysmawaits.item.custom.FuelItem;
import net.foxtrot.cataclysmawaits.item.custom.ModToolTiers;
import net.foxtrot.cataclysmawaits.item.custom.MushletCapCap;
import net.foxtrot.cataclysmawaits.item.custom.TotemOfReturn;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CataclysmAwaits.MOD_ID);

    public static final DeferredItem<Item> GIL = ITEMS.register("gil",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SIL = ITEMS.register("sil",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> THEHORROR = ITEMS.register("thehorror",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MUSHROGLYCERIN = ITEMS.register("mushroglycerin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TOTEMOFRETURN = ITEMS.register("totemofreturn",
            () -> new TotemOfReturn(new Item.Properties()));

    public static final DeferredItem<Item> MUSHLETCAPCAP = ITEMS.register("mushletcapcap",
            () -> new MushletCapCap(ModArmorMaterials.MUSHLET_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> GLAPPLE = ITEMS.register("glapple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GLAPPLE)));
    public static final DeferredItem<Item> FRIEDMUSHLETCAPCAP = ITEMS.register("friedmushletcapcap",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FRIEDMUSHLETCAPCAP)));
    public static final DeferredItem<Item> CATACLYSTFUEL = ITEMS.register("cataclystfuel",
            () -> new FuelItem(new Item.Properties(), 2147483647));


    public static final DeferredItem<PickaxeItem> THE_SPOON = ITEMS.register("thespoon",
            () -> new PickaxeItem(ModToolTiers.SPOON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SPOON,3,8))));

    public static final DeferredItem<Item> MUSHLET_SPAWN_EGG = ITEMS.register("mushletspawnegg",
            () -> new DeferredSpawnEggItem(ModEntities.MUSHLET, 0xFFFF00, 0x880808,
                    new Item.Properties()));
    public static final DeferredItem<Item> MUSHBOOM_SPAWN_EGG = ITEMS.register("mushboomspawnegg",
            () -> new DeferredSpawnEggItem(ModEntities.MUSHBOOM, 0x880808, 0xFFFF00,
                    new Item.Properties()));

    public static final DeferredItem<Item> GLOG_ITEM = ITEMS.register("glog",
            () -> new BlockItem(ModBlocks.GLOG.get(), new Item.Properties()));
    public static final DeferredItem<Item> FROX_ITEM = ITEMS.register("frox",
            () -> new BlockItem(ModBlocks.FROX.get(), new Item.Properties()));
    public static final DeferredItem<Item> PROG_ITEM = ITEMS.register("prog",
            () -> new BlockItem(ModBlocks.PROG.get(), new Item.Properties()));
    public static final DeferredItem<Item> DROG_ITEM = ITEMS.register("drog",
            () -> new BlockItem(ModBlocks.DROG.get(), new Item.Properties()));
    public static final DeferredItem<Item> SOG_ITEM = ITEMS.register("sog",
            () -> new BlockItem(ModBlocks.SOG.get(), new Item.Properties()));
    public static final DeferredItem<Item> MOG_ITEM = ITEMS.register("mog",
            () -> new BlockItem(ModBlocks.MOG.get(), new Item.Properties()));
    public static final DeferredItem<Item> XROG_ITEM = ITEMS.register("xrog",
            () -> new BlockItem(ModBlocks.XROG.get(), new Item.Properties()));
    public static final DeferredItem<Item> SKROG_ITEM = ITEMS.register("skrog",
            () -> new BlockItem(ModBlocks.SKROG.get(), new Item.Properties()));







    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
