package com.valiantmarauders.minecraft.block;

import org.bukkit.Material;
import org.bukkit.block.Block;

public interface BlockChangeDatabase {
	/**
	 * Stores the original type of Block and then changes the Material of the
	 * Block to the given type.
	 * 
	 * @param block
	 *            the Block to change
	 * @param material
	 *            the Material to change the Block to
	 */
	public void change(Block block, Material material);

	/**
	 * Restores the Block to it's original Material and removes the stored
	 * entry.
	 * 
	 * @param block
	 *            the Block to restore
	 */
	public void restore(Block block);

	/**
	 * Checks to see if the given Block is changed.
	 * 
	 * @param block
	 *            the Block to check
	 * @return true if the Block is changed
	 */
	public boolean isChanged(Block block);

	/**
	 * Restore all changed Blocks to their original Material.
	 */
	public void restoreAll();
}
