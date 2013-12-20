package com.valiantmarauders.minecraft.command;

//These are the two imports I used, but you can change the actual onCommand to whatever suits your needs.
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;

//IMPORTANT: This is an interface, not a class.
public interface CommandInterface extends CommandExecutor {
	// Every time I make a command, I will use this same method.
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args);
}
