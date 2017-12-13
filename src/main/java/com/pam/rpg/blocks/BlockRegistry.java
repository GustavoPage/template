package com.pam.rpg;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public final class BlockRegistry {

	public static final List<Block> blocks = new ArrayList<Block>();
	
	public static Block pamFossil;
	public static ItemBlock pamfossilItemBlock;

    private static boolean initialized = false;

    public static void initBlockRegistry() {

        registerFossil();
        initialized = true;
    }

   

    private static void registerFossil() {
    	pamFossil = new BlockPamFossil().setHardness(3.0F).setResistance(5.0F);
        pamfossilItemBlock = new ItemBlock(pamFossil);
        ItemRegistry.items.put(BlockPamFossil.registryName, pamfossilItemBlock);
        registerBlock(BlockPamFossil.registryName, pamfossilItemBlock, pamFossil);
    }

   
    public static void registerBlock(String registerName, ItemBlock itemBlock, Block block) {
        block.setRegistryName(registerName);
        block.setUnlocalizedName(registerName);
        block.setCreativeTab(rpg.tabRpg);
        blocks.add(block);

        itemBlock.setRegistryName(registerName);
        itemBlock.setUnlocalizedName(registerName);

    }

    public static void registerBlock(String registerName, Block block) {
        final ItemBlock itemBlock = new ItemBlock(block);
        registerBlock(registerName, itemBlock, block);
    }

    
    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> reg = e.getRegistry();
        reg.registerAll(blocks.toArray(new Block[0]));        
    }
    
}
