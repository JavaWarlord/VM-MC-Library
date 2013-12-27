package com.valiantmarauders.minecraft.selection;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CuboidSelectionManager {

	// private static final int GUIDEGAP = 3;
	protected Map<Player, CuboidSelection> selections;
	private Material wand;
	// private BlockChangeDatabase blockDB;
	// private Material guideMaterial = Material.WOOL;
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

	// @Override
	// public void addPoint(Player player, Material material, Block block) {
	// // TODO Auto-generated method stub
	// if (material == getWand()) {
	// Selection selection = selections.get(player);
	// if (selection == null) {
	// // create new Selection
	// selection = new CuboidSelection();
	// selection.add(block.getLocation());
	// selection.add(block.getLocation());
	// selections.put(player, selection);
	// addGuides(selection);
	// } else {
	// // add to existing Selection
	// removeGuides(selection);
	// selection.add(block.getLocation());
	// addGuides(selection);
	// }
	// }
	// }

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
}
