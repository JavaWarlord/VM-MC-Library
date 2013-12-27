package com.valiantmarauders.minecraft.selection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.valiantmarauders.minecraft.block.BlockChangeDatabase;
import com.valiantmarauders.minecraft.block.FlatFileBlockChangeDatabase;

public class CuboidSelectionManager implements SelectionManager {

	private static final int GUIDEGAP = 3;
	private Map<Player, Selection> selections;
	private Material selectionWand;
	private BlockChangeDatabase blockDB;
	private Material guideMaterial = Material.WOOL;
	private JavaPlugin plugin;

	public CuboidSelectionManager(JavaPlugin plugin, Material selectionWand) {
		// TODO Auto-generated constructor stub
		this.setPlugin(plugin);
		this.selectionWand = selectionWand;
		blockDB = new FlatFileBlockChangeDatabase(plugin);
		selections = new HashMap<Player, Selection>();
	}

	@Override
	public void addPoint(Player player, ItemStack wand, Block block) {
		// TODO Auto-generated method stub
		if (wand.getType() == selectionWand) {
			Selection selection = selections.get(player);
			if (selection == null) {
				// create new Selection
				CuboidSelection newSelection = new CuboidSelection();
				newSelection.add(block.getLocation());
				newSelection.add(block.getLocation());
				selections.put(player, newSelection);
			} else {
				// add to existing Selection
				removeGuides(selection);
				selection.add(block.getLocation());
				addGuides(selection);
			}
		}
	}

	/**
	 * Adds the guide blocks to the selection area.
	 * 
	 * @param selection
	 */
	private void addGuides(Selection selection) {
		// TODO Auto-generated method stub
		ArrayList<Location> guideBlockLocations = new ArrayList<Location>();
		guideBlockLocations.addAll(selection.getPoints());
		List<Block> guides = calculateGuides(selection);
		for (Block b : guides) {
			guideBlockLocations.add(b.getLocation());
		}
		for (Location loc : guideBlockLocations) {
			blockDB.add(loc, guideMaterial);
		}
	}

	private void removeGuides(Selection selection) {
		// TODO Auto-generated method stub
		ArrayList<Location> guideBlockLocations = new ArrayList<Location>();
		guideBlockLocations.addAll(selection.getPoints());
		List<Block> guides = calculateGuides(selection);
		for (Block b : guides) {
			guideBlockLocations.add(b.getLocation());
		}
		for (Location p : guideBlockLocations) {
			blockDB.restore(p);
		}
	}

	/*
	 * private void updateDisplay(Selection selection) { // TODO Auto-generated
	 * method stub removeGuides(player); setGuides(player, selection);
	 * List<Location> points = selection.getPoints(); for (Location p : points)
	 * { } }
	 */

	private List<Block> calculateGuides(Selection selection) {
		// TODO Auto-generated method stub
		World world = selection.getPoints().get(0).getWorld();
		List<Location> points = selection.getPoints();
		List<Block> guides = new ArrayList<Block>();
		int x1 = (int) points.get(0).getX();
		int x2 = (int) points.get(1).getX();
		int y1 = (int) points.get(0).getY();
		int y2 = (int) points.get(1).getY();
		int z1 = (int) points.get(0).getZ();
		int z2 = (int) points.get(1).getZ();
		int minX = (int) Math.min(x1, x2);
		int maxX = (int) Math.max(x1, x2);
		int minY = (int) Math.min(y1, y2);
		int maxY = (int) Math.max(y1, y2);
		int minZ = (int) Math.min(z1, z2);
		int maxZ = (int) Math.max(z1, z2);
		for (int x = minX; x < maxX; x++) {
			for (int y = minY; y < maxY; y++) {
				for (int z = minZ; z < maxZ; z++) {
					if (x == x1 || x == x2 || y == y1 || y == y2 || z == z1
							|| z == z2) {
						if (x % GUIDEGAP == 0 && y % GUIDEGAP == 0
								&& z % GUIDEGAP == 0) {
							Location loc = new Location(world, x, y, z);
							if (!selection.getPoints().contains(loc)) {
								guides.add(new Location(world, x, y, z)
										.getBlock());
							}
						}
					}
				}
			}
		}
		return guides;
	}

	public JavaPlugin getPlugin() {
		return plugin;
	}

	public void setPlugin(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void addPoint(Player player, Material type, Block block) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Location> getSelection(Player player) {
		// TODO Auto-generated method stub
		return null;
	}
}
