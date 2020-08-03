package com.rifledluffy.chairs.command.commands;

import java.util.List;
import java.util.UUID;

import com.rifledluffy.chairs.MessageManager;
import com.rifledluffy.chairs.RFChairs;
import com.rifledluffy.chairs.utility.Util;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class MuteCommand implements SubCommand {
	
	private RFChairs plugin = RFChairs.getInstance();
    
    @Override
	public void onCommand(ConsoleCommandSender sender, String[] args) {
      sender.sendMessage("§cOnly players can use commands for this plugin.");
	}

	@Override
	public void onCommand(Player player, String[] args) {
		MessageManager messageManager = plugin.messageManager;
		List<UUID> muted = messageManager.muted;
		String message;
		if (!player.hasPermission("rfchairs.mute")) return;
		if (muted.contains(player.getUniqueId())) {
			String string = messageManager.messages.getString("mute-message-enabled", "&8[&6Rifle's Chairs&8] &7Event Messaging is now &cDisabled!");
			message = Util.replaceMessage(player, string);
			player.sendMessage(message);
			muted.remove(player.getUniqueId());
		}
		else {
			String string = messageManager.messages.getString("mute-message-disabled", "&8[&6Rifle's Chairs&8] &7Event Messaging is now &aEnabled!");
			message = Util.replaceMessage(player, string);
			player.sendMessage(message);
			muted.add(player.getUniqueId());
		}
	}

	@Override
	public String name() {
		return plugin.commandManager.mute;
	}

}
