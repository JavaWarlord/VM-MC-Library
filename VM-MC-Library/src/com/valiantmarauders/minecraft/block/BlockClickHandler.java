package com.valiantmarauders.minecraft.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

public interface BlockClickHandler {

	/**
	 * Called by a Listener.
	 * 
	 * @param player
	 *            the player who clicked the block
	 * @param action 
	 * @param material
	 *            what they clicked the block with
	 * @param block
	 *            the block they clicked
	 */
	void notify(Player player, Action action, Material material, Block block);
}
