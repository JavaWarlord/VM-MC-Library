package com.valiantmarauders.minecraft.location;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;

import com.valiantmarauders.minecraft.block.Cuboid;

public interface CuboidManager {
	/**
	 * Displays all of the Cuboids.
	 * 
	 * @param sender
	 *            the sender
	 */
	void display(CommandSender sender);

	/**
	 * Checks if the given Location exists in any of the defined Cuboids.
	 * 
	 * @param location
	 *            the Location to check
	 * @return true if the Location is in a defined Cuboid
	 */
	boolean contains(Location location);

	/**
	 * Gets the Cuboid containing the given Location.
	 * 
	 * @param location
	 *            the Location
	 * @return the Cuboid containing the Location
	 */
	Cuboid get(Location location);

	/**
	 * Adds a Cuboid to the defined Cuboids.
	 * 
	 * @param cuboid
	 *            the Cuboid to add
	 * @return true if successful
	 */
	boolean add(Cuboid cuboid);

	/**
	 * Removes the given Cuboid from the defined Cuboids.
	 * 
	 * @param cuboid
	 *            the Cuboid to remove
	 * @return true if successful
	 */
	boolean remove(Cuboid cuboid);

	/**
	 * Deletes all of the defined Cuboids.
	 */
	void removeAll();

	/**
	 * Returns a List of all the defined Cuboids.
	 * 
	 * @return a List of Cuboids
	 */
	List<Cuboid> getCuboids();

	/**
	 * Loads a List of Cuboids from a file
	 * 
	 * @return
	 */
	List<Cuboid> load();

	/**
	 * Saves the defined Cuboids to a file
	 */
	void save();

}
