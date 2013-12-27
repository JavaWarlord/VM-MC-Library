package com.valiantmarauders.minecraft.selection;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 * Manages the creation, deletion, and displaying of selections made by a
 * player.
 * 
 * @author JavaWarlord
 * 
 */
public interface SelectionManager {
	/**
	 * Adds a point to the Selection. Creates a new Selection if one doesn't
	 * already exist.
	 * 
	 * @param player
	 *            the player selection the point
	 * 
	 * @param type
	 *            the type of item used to make the selection
	 * @param block
	 *            the block selected
	 */
	public void addPoint(Player player, Material type, Block block);

	/**
	 * Gets the Selection related to a Player
	 * 
	 * @param player
	 *            the player whos selection to get
	 * 
	 * @return the selection
	 */
	public Selection getSelection(Player player);
}
