package com.valiantmarauders.minecraft.selection;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
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
	 * Adds a point to the Selection. Creates a new Selection if one doesn't
	 * already exist.
	 * 
	 * @param player
	 *            the player selecting the point
	 * 
	 * @param wand
	 *            the item used to make the selection
	 * @param block
	 *            the block selected
	 */
	public void addPoint(Player player, ItemStack wand, Block block);

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
