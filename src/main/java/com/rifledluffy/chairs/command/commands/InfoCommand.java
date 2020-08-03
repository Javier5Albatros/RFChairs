package com.rifledluffy.chairs.command.commands;

import com.rifledluffy.chairs.RFChairs;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements SubCommand {
	
    private RFChairs plugin = RFChairs.getInstance();
    
    @Override
	public void onCommand(ConsoleCommandSender sender, String[] args) {
      sender.sendMessage("§cOnly players can use commands for this plugin.");
	}

    @Override
    public void onCommand(Player player, String[] args) {
    }

    @Override
    public String name() {
        return plugin.commandManager.info;
    }

}