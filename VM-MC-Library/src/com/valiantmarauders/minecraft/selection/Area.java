package com.valiantmarauders.minecraft.selection;

import org.bukkit.Location;

public abstract class Area {

	public abstract boolean contains(Location location);

	public abstract Area clone();
}
