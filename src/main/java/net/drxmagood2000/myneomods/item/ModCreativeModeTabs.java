package net.drxmagood2000.myneomods.item;

import net.drxmagood2000.myneomods.MyNeoMods;
import net.drxmagood2000.myneomods.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyNeoMods.MOD_ID);

    public static final Supplier<CreativeModeTab> SAPPHIRE_ITEMS_TAB = CREATIVE_MODE_TAB.register("sapphire_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.drxneomods.sapphire_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SAPPHIRE);
                        output.accept(ModItems.RAW_SAPPHIRE);
                    }).build());

    public static final Supplier<CreativeModeTab> SAPPHIRE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("sapphire_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SAPPHIRE_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MyNeoMods.MOD_ID, "sapphire_items_tab"))
                    .title(Component.translatable("creativetab.drxneomods.sapphire_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SAPPHIRE_BLOCK);
                        output.accept(ModBlocks.SAPPHIRE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
