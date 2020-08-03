package com.rifledluffy.chairs.command.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public interface SubCommand {

    /*
    /<command> <subcommand> args[0] args[1]
     */
    
    default void onCommand(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            onCommand((Player) sender, args);
        } else if (sender instanceof ConsoleCommandSender) {
            onCommand((ConsoleCommandSender) sender, args);
        } else return;
    }
    
    void onCommand(ConsoleCommandSender sender, String[] args);

    void onCommand(Player player, String[] args);

    String name();

    default String info() {
        return "";
    }

    default String[] aliases() {
        return new String[0];
    }
}
