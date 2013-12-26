package com.valiantmarauders.minecraft.block;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class GenericBlockChangeDataBase implements BlockChangeDatabase {
	private JavaPlugin plugin;
	private String directoryName;
	private String fileName;
	private Map<Location, Material> blocks;

	public GenericBlockChangeDataBase(JavaPlugin plugin, String directoryName) {
		super();
		this.plugin = plugin;
		this.directoryName = directoryName;
		this.fileName = "block.db";
	}

	@Override
	public void change(Location location, Material material) {
		// Is there already an entry for this location?
		if (blocks.containsKey(location)) {
			// Update block in the world only
			location.getBlock().setType(material);
		} else {
			// Add the location and type to the database
			blocks.put(location, location.getBlock().getType());
			// Change the block in the world
			location.getBlock().setType(material);
		}
	}

	@Override
	public boolean isChanged(Location location) {
		// TODO Auto-generated method stub
		return blocks.containsKey(location);
	}

	@Override
	public Map<Location, Material> load() {
		// TODO Auto-generated method stub
		plugin.getLogger().info("Loading blocks");
		File file = new File("plugins/" + directoryName + "/" + fileName);
		// List<Cuboid> areas = new ArrayList<Cuboid>();
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(file.getAbsolutePath()));
				Object object = ois.readObject();
				@SuppressWarnings("unchecked")
				ArrayList<String> result = (ArrayList<String>) object;
				for (String line : result) {
					plugin.getLogger().info(line);
				}
				ois.close();
			} catch (Exception e) {
				plugin.getLogger().warning("Error reading " + fileName);
				plugin.getLogger().warning(e.toString());
			}
		}
		return null;
	}

	@Override
	public void restore(List<Location> guides) {
		// TODO Auto-generated method stub
		for (Location loc : guides) {
			restore(loc);
		}
	}

	@Override
	public void restore(Location location) {
		// TODO Auto-generated method stub
		location.getBlock().setType(blocks.remove(location));
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		File file = new File("plugins/" + directoryName + "/" + fileName);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file.getAbsolutePath()));
			ArrayList<String> format = new ArrayList<String>();
			for (Entry<Location, Material> entry : blocks.entrySet()) {
				format.add(entry.getKey().toString());
				format.add(entry.getValue().toString());
			}
			oos.writeObject(format);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			plugin.getLogger().warning("Error writing " + fileName);
			plugin.getLogger().warning(e.toString());
		}
	}

	@Override
	public void restoreAll() {
		// TODO Auto-generated method stub
		for (Entry<Location, Material> entry : blocks.entrySet()) {
			entry.getKey().getBlock().setType(entry.getValue());
		}
		blocks.clear();
	}
}
