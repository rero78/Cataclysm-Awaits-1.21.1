package net.foxtrot.cataclysmawaits.item;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.item.custom.TotemOfReturn;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CataclysmAwaits.MOD_ID);

    public static final DeferredItem<Item> GIL = ITEMS.register("gil",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SIL = ITEMS.register("sil",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TOTEMOFRETURN = ITEMS.register("totemofreturn",
            () -> new TotemOfReturn(new Item.Properties()));

    public static final DeferredItem<Item> GLAPPLE = ITEMS.register("glapple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GLAPPLE)));
    public static final DeferredItem<Item> FRIEDMUSHLETCAPCAP = ITEMS.register("friedmushletcapcap",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FRIEDMUSHLETCAPCAP)));
    public static final DeferredItem<ArmorItem> MUSHLETCAPCAP = ITEMS.register("mushletcapcap",
            () -> new ArmorItem(ModArmorMaterials.MUSHLET_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
