package com.valiantmarauders.minecraft.block;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.valiantmarauders.minecraft.selection.SelectionManager;

public class PlayerSelectBlockListener implements Listener {
	private JavaPlugin plugin;
	private SelectionManager sm;

	public PlayerSelectBlockListener(JavaPlugin plugin, SelectionManager sm) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
		this.sm = sm;
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
	public void onPlayerInteract(PlayerInteractEvent event) {
		Block block = event.getClickedBlock();
		sm.addPoint(event.getPlayer(), event.getItem(), block);
	}
}
