package com.valiantmarauders.minecraft.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Manages the creation, deletion, and displaying of selections made by a
 * player.
 * 
 * @author JavaWarlord
 * 
 */
public interface SelectionManager {
	/**
	 * Gets the {@link org.bukkit.entity.Player Player} making the selection.
	 * 
	 * @return the player
	 */
	public Player getPlayer(Selection selection);

	/**
	 * Sets the {@link org.bukkit.entity.Player Player} making the selection.
	 * 
	 * @param player
	 *            the player
	 */
	public void setPlayer(Selection selection, Player player);

	/**
	 * Adds a point to the Selection. Creates a new Selection if one doesn't
	 * already exist.
	 * 
	 * @param wand
	 *            the item used to make the selection
	 * @param block
	 *            the block selected
	 */
	public void addPoint(ItemStack wand, Block block);
}
