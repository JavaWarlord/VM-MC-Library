package com.valiantmarauders.minecraft.selection;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CuboidSelectionManager {

	protected Map<Player, CuboidSelection> selections;
	private Material wand;
	private JavaPlugin plugin;

	public CuboidSelectionManager(JavaPlugin plugin, Material material) {
		// TODO Auto-generated constructor stub
		this.setPlugin(plugin);
		this.setWand(material);
		// blockDB = new FlatFileBlockChangeDatabase(plugin);
		selections = new HashMap<Player, CuboidSelection>();
	}

	public Selection getSelection(Player player) {
		// TODO Auto-generated method stub
		return selections.get(player);
	}

	public Material getWand() {
		return wand;
	}

	public void setWand(Material wand) {
		this.wand = wand;
	}

	public JavaPlugin getPlugin() {
		return plugin;
	}

	public void setPlugin(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public abstract void restoreAll();
}
