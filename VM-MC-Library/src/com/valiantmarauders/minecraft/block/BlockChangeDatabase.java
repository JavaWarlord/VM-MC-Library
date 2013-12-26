package com.valiantmarauders.minecraft.block;

import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public interface BlockChangeDatabase {
	/**
	 * Stores the type of {@link Block} at the given {@link Location} and the
	 * changes the Block in the world to given {@link Material}.
	 * 
	 * @param location
	 *            the location of the block to change
	 * @param material
	 *            the new block
	 */
	public void change(Location location, Material material);

	/**
	 * Checks to see if the {@link Block} at the given {@link Location} is
	 * changed.
	 * 
	 * @param location
	 *            the Block to check
	 * @return true if the Block is changed
	 */
	public boolean isChanged(Location location);

	/**
	 * Loads a Map of changed Block locations from a file
	 * 
	 * @return
	 */
	Map<Location, Material> load();

	/**
	 * Saves the changed Blocks to a file
	 */
	void save();

	/**
	 * Restores the {@link Block} at this {@link Location} is changed. to it's
	 * original {@link Material} and removes the stored entry.
	 * 
	 * @param location
	 *            the Location of the Block to restore
	 */
	public void restore(Location location);

	/**
	 * Restores a list of {@link Block} {@link Location Locations} to their
	 * original {@link Material} and removes the stored entry.
	 * 
	 * @param guides
	 *            the List of the Locations of the Blocks to restore
	 */
	public void restore(List<Location> guides);

	/**
	 * Restore all changed Blocks to their original Material.
	 */
	public void restoreAll();
}
