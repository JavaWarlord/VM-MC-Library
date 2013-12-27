package com.valiantmarauders.minecraft.selection;

import java.util.List;

import org.bukkit.block.Block;

public interface DisplayableSelection {
	void addGuides(Selection selection);

	void removeGuides(Selection selection);
	
	List<Block> calculateGuides(Selection selection);
}
