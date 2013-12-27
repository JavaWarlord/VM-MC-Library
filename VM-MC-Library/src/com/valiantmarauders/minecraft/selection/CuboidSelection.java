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
	private List<Location> points;

	public CuboidSelection() {
		points = new ArrayList<Location>();
	}

	@Override
	public List<Location> getPoints() {
		// TODO Auto-generated method stub
		return points;
	}

	@Override
	public boolean add(Location location) {
		// TODO Auto-generated method stub
		points.add(location);
		if (points.size() > MAXPOINTS)
			points.remove(0);
		return true;
	}

	@Override
	public boolean remove(Location location) {
		// TODO Auto-generated method stub
		return points.remove(location);
	}
}
