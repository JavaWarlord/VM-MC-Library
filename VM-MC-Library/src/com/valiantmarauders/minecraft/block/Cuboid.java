package com.valiantmarauders.minecraft.block;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;

/**
 * Defines the boundaries of a cube using points in opposite corners. In
 * geometry, a cuboid is a convex polyhedron bounded by six quadrilateral faces,
 * whose polyhedral graph is the same as that of a cube.
 * 
 * @author JavaWarlord
 * @version 0.1
 * 
 */
public class Cuboid {

	private static final int MAX_POINTS = 2;
	// @Deprecated
	// private World world;
	// @Deprecated
	// private int x1;
	// @Deprecated
	// private int y1;
	// @Deprecated
	// private int z1;
	// @Deprecated
	// private int x2;
	// @Deprecated
	// private int y2;
	// @Deprecated
	// private int z2;
	private List<Location> bounderies;

	@Deprecated
	public Cuboid(World world, int x1, int y1, int z1, int x2, int y2, int z2) {
		// TODO Auto-generated constructor stub
		bounderies = new ArrayList<Location>();
		bounderies.add(new Location(world, x1, y1, z1));
		bounderies.add(new Location(world, x2, y2, z2));
	}

	@Deprecated
	public Cuboid(World world, Location location1, Location location2) {
		// TODO Auto-generated constructor stub
		this(world, Math.min(location1.getBlockX(), location2.getBlockX()),
				Math.min(location1.getBlockY(), location2.getBlockY()), Math
						.min(location1.getBlockZ(), location2.getBlockZ()),
				Math.max(location1.getBlockX(), location2.getBlockX()), Math
						.max(location1.getBlockY(), location2.getBlockY()),
				Math.max(location1.getBlockZ(), location2.getBlockZ()));
	}

	public Cuboid(List<Location> bounderies) {
		// TODO Auto-generated constructor stub
		this.bounderies = bounderies;
	}

	public boolean contains(Location location) {
		// TODO Auto-generated method stub
		if (location.getX() < Math.min(bounderies.get(0).getX(), bounderies
				.get(1).getX()))
			return false;
		if (location.getX() > Math.max(bounderies.get(0).getX(), bounderies
				.get(1).getX()))
			return false;
		if (location.getY() < Math.min(bounderies.get(0).getY(), bounderies
				.get(1).getY()))
			return false;
		if (location.getY() > Math.max(bounderies.get(0).getY(), bounderies
				.get(1).getY()))
			return false;
		if (location.getZ() < Math.min(bounderies.get(0).getZ(), bounderies
				.get(1).getZ()))
			return false;
		if (location.getZ() > Math.max(bounderies.get(0).getZ(), bounderies
				.get(1).getZ()))
			return false;
		return true;
	}

	public Cuboid clone() {
		// TODO Auto-generated method stub
		return new Cuboid(bounderies);
	}

//	public String toSaveFormat() {
//		StringBuilder sb = new StringBuilder();
//		sb.append(bounderies.get(0).getWorld().getName());
//		sb.append(",");
//		for (Location loc : bounderies) {
//			sb.append(loc.getX());
//			sb.append(",");
//			sb.append(loc.getY());
//			sb.append(",");
//			sb.append(loc.getZ());
//		}
//		return sb.toString();
//	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(bounderies.get(0).getWorld().getName());
		sb.append("]\n");
		for (Location loc : bounderies) {
			sb.append("{");
			sb.append(loc.getX());
			sb.append(",");
			sb.append(loc.getY());
			sb.append(",");
			sb.append(loc.getZ());
			sb.append("}\n");
		}
		return sb.toString();
	}

	public List<Location> getPoints() {
		// TODO Auto-generated method stub
		return bounderies;
	}

	public boolean add(Location location) {
		// TODO Auto-generated method stub
		boolean result = bounderies.add(location);
		if (bounderies.size() > MAX_POINTS)
			bounderies.remove(0);
		return result;
	}

	public boolean remove(Location location) {
		// TODO Auto-generated method stub
		return bounderies.remove(location);
	}

	public void setWorld(World world) {
		// TODO Auto-generated method stub

	}

	public World getWorld() {
		// TODO Auto-generated method stub
		if (!bounderies.isEmpty())
			return bounderies.get(0).getWorld();
		else
			return null;
	}
}
