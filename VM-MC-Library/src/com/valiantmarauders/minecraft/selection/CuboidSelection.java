package com.valiantmarauders.minecraft.selection;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

/**
 * A cuboid selection represented by two points. If a third points is added, the
 * first one is removed in a FIFO fashion.
 * 
 * @author JavaWarlord
 * 
 */
public class CuboidSelection implements Selection {

	private static final int MAXPOINTS = 2;
	private Location[] points;

	public CuboidSelection() {
		points = new Location[MAXPOINTS];
	}

	@Override
	public List<Location> getPoints() {
		// TODO Auto-generated method stub
		List<Location> pointsList = new ArrayList<Location>();
		pointsList.add(points[0]);
		pointsList.add(points[1]);
		return pointsList;
	}

	@Override
	public boolean add(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	public void set(int index, Location location) {
		// TODO Auto-generated method stub
		points[index] = location;
	}

	public Location get(int index) {
		// TODO Auto-generated method stub
		return points[index];
	}
}
