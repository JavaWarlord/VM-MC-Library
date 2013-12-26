package com.valiantmarauders.minecraft.block;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class FlatFileBlockChangeDatabase implements BlockChangeDatabase {
	private JavaPlugin plugin;
	private String directoryName;
	private String fileName;
	private Map<Location, Material> blocks;

	public FlatFileBlockChangeDatabase(JavaPlugin plugin) {
		this(plugin, plugin.getName(), "block.db");
	}

	public FlatFileBlockChangeDatabase(JavaPlugin plugin, String directoryName,
			String fileName) {
		// TODO Auto-generated constructor stub
		super();
		this.plugin = plugin;
		this.directoryName = directoryName;
		this.fileName = fileName;
		this.blocks = new HashMap<Location, Material>();
	}

	@Override
	public void add(Location location, Material type) {
		// TODO Auto-generated method stub
		if (!exists(location)) {
			blocks.put(location, type);
		}
		location.getBlock().setType(type);
	}

	@Override
	public boolean exists(Location location) {
		// TODO Auto-generated method stub
		return blocks.containsKey(location);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Location, Material> load() {
		// TODO Auto-generated method stub
		File file = new File("plugins/" + directoryName + "/" + fileName);
		if (file.exists()) {
			try {
				plugin.getLogger().info(
						"Loading from " + file.getCanonicalPath().toString());
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(file.getAbsolutePath()));
				// ArrayList<String> result;
				blocks = (Map<Location, Material>) ois.readObject();
				// for (String line : result) {
				// commaPos=line.
				// key=line.subSequence(beginIndex, endIndex)
				// }
				ois.close();
			} catch (Exception e) {
				plugin.getLogger().warning("Error reading " + fileName);
				plugin.getLogger().warning(e.toString());
			}
		} else {
			plugin.getLogger().info("Database file doesn't exist.");
		}
		return blocks;
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		File file = new File("plugins/" + directoryName + "/" + fileName);
		try {
			plugin.getLogger().info(
					"Saving to " + file.getCanonicalPath().toString());
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file.getAbsolutePath()));

			// ArrayList<String> format = new ArrayList<String>();
			// for (Entry<Location, Material> entry : blocks.entrySet()) {
			// format.add(entry.getKey().toString() + ","
			// + entry.getValue().toString());
			// }
			// oos.writeObject(format);
			oos.writeObject(blocks);
			oos.flush();
			oos.close();
			return true;
		} catch (Exception e) {
			plugin.getLogger().warning("Error writing " + fileName);
			plugin.getLogger().warning(e.toString());
			return false;
		}
	}

	@Override
	public void restore(Location location) {
		// TODO Auto-generated method stub
		location.getBlock().setType(blocks.remove(location));
	}

	@Override
	public void restore(List<Location> locations) {
		// TODO Auto-generated method stub
		for (Location loc : locations) {
			restore(loc);
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
