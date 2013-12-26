package com.valiantmarauders.minecraft.block;

import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public interface BlockChangeDatabase {
	/**
	 * Stores the type of {@link Block} at the given {@link Location} and then
	 * changes the Block in the world to given {@link Material}.
	 * 
	 * @param location
	 *            the location of the block to change
	 * @param material
	 *            the new block
	 */
	public void add(Location location, Material type);

	/**
	 * Checks to see if there is an entry for that {@link Location} in the
	 * database.
	 * 
	 * @param location
	 *            the location to check
	 * @return true if the Block is changed
	 */
	public boolean exists(Location location);

	/**
	 * Loads a saved {@link Map} of changed {@link Location Locations} and
	 * {@link Material Materials}.
	 * 
	 * @return the map
	 */
	Map<Location, Material> load();

	/**
	 * Saves a {@link Map} of changed {@link Location Locations} and
	 * {@link Material Materials}.
	 */
	public boolean save();

	/**
	 * Restores the changed {@link Block} at this {@link Location} to it's
	 * original {@link Material} and removes the stored entry.
	 * 
	 * @param location
	 *            the Location of the Block to restore
	 */
	public void restore(Location location);

	/**
	 * Restores the changed {@link Block Blocks} at these {@link Location
	 * Locations} to their original {@link Material} and removes the stored
	 * entries.
	 * 
	 * @param locations
	 *            the list of the locations of the blocks to restore
	 */
	public void restore(List<Location> locations);

	/**
	 * Restore all changed {@link Block Blocks} to their original
	 * {@link Material}.
	 */
	public void restoreAll();
}
