package com.valiantmarauders.minecraft.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface BlockClickHandler {

	/**
	 * Called by a Listener.
	 * 
	 * @param player
	 *            the player who clicked the block
	 * @param itemStack
	 *            what they clicked the block with
	 * @param block
	 *            the block they clicked
	 */
	void notify(Player player, ItemStack itemStack, Block block);
}
