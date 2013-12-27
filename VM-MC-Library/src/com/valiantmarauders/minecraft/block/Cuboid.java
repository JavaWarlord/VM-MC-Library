package com.valiantmarauders.minecraft.block;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;

import com.valiantmarauders.minecraft.selection.Area;

/**
 * Defines the boundaries of a cube using points in opposite corners. In
 * geometry, a cuboid is a convex polyhedron bounded by six quadrilateral faces,
 * whose polyhedral graph is the same as that of a cube.
 * 
 * @author JavaWarlord
 * @version 0.1
 * 
 */
public class Cuboid extends Area {

	private static final int MAX_POINTS = 2;
	private List<Location> points;

	public Cuboid(List<Location> points) {
		// TODO Auto-generated constructor stub
		this.points = points;
	}

	public boolean add(Location location) {
		// TODO Auto-generated method stub
		boolean result = points.add(location);
		if (points.size() > MAX_POINTS)
			points.remove(0);
		return result;
	}

	public boolean contains(Location location) {
		// TODO Auto-generated method stub
		if (location.getX() < Math.min(points.get(0).getX(), points.get(1)
				.getX()))
			return false;
		if (location.getX() > Math.max(points.get(0).getX(), points.get(1)
				.getX()))
			return false;
		if (location.getY() < Math.min(points.get(0).getY(), points.get(1)
				.getY()))
			return false;
		if (location.getY() > Math.max(points.get(0).getY(), points.get(1)
				.getY()))
			return false;
		if (location.getZ() < Math.min(points.get(0).getZ(), points.get(1)
				.getZ()))
			return false;
		if (location.getZ() > Math.max(points.get(0).getZ(), points.get(1)
				.getZ()))
			return false;
		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(points.get(0).getWorld().getName());
		sb.append("]\n");
		for (Location loc : points) {
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
		return points;
	}

	public boolean remove(Location location) {
		// TODO Auto-generated method stub
		return points.remove(location);
	}

	public void setWorld(World world) {
		// TODO Auto-generated method stub

	}

	public World getWorld() {
		// TODO Auto-generated method stub
		if (!points.isEmpty())
			return points.get(0).getWorld();
		else
			return null;
	}

	@Override
	public Area clone() {
		// TODO Auto-generated method stub
		return new Cuboid(points);
	}
}
