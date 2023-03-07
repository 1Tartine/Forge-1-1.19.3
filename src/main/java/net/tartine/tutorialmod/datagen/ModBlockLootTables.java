package net.tartine.tutorialmod.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.tartine.tutorialmod.block.ModBlocks;
import net.tartine.tutorialmod.item.ModItems;


import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RED_PEARL_BLOCK.get());

        add(ModBlocks.HAZARD_BLOCK.get(),
                (block) -> createOreDrop(ModBlocks.HAZARD_BLOCK.get(), ModItems.RED_PEARL.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
