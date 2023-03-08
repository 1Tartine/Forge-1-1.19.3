package net.tartine.tutorialmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tartine.tutorialmod.TutorialMod;
import net.tartine.tutorialmod.block.custom.CapacitorBlock;
import net.tartine.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final  RegistryObject<Block> RED_PEARL_BLOCK = registerBlock("red_pearl_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()));

    public static final  RegistryObject<Block> HAZARD_BLOCK = registerBlock("hazard_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST), UniformInt.of(10, 30)));

    public static final  RegistryObject<Block> CAPACITOR_BLOCK = registerBlock("capacitor_block",
            () -> new CapacitorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops().noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
