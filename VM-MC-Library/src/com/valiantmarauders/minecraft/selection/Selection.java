package com.valiantmarauders.minecraft.selection;

import java.util.List;

import org.bukkit.Location;

/**
 * Represents an area in a single {@link org.bukkit.World World} bounded by
 * {@link org.bukkit.Location Locations}.
 * 
 * @author JavaWarlord
 * 
 */
public interface Selection {

	/**
	 * Get a list of all the boundary {@link org.bukkit.Location Locations}.
	 * 
	 * @return a list of the locations
	 */
	public List<Location> getPoints();

	/**
	 * Adds a {@link org.bukkit.Location Location} to the list of boundary
	 * points.
	 * 
	 * @param location
	 *            the location
	 */
	public boolean add(Location location);

	/**
	 * Removes a {@link org.bukkit.Location Location} from the list of boundary
	 * points.
	 * 
	 * @param location
	 *            the location
	 */
	public boolean remove(Location location);
}
