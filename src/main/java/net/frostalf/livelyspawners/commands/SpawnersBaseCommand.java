/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners.commands;

import net.frostalf.livelyspawners.LivelySpawners;
import net.frostalf.livelyspawners.util.SpawnersPermEnum;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Frostalf
 */
public class SpawnersBaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        Player player = (Player) cs;
        if (player.hasPermission(SpawnersPermEnum.ADMIN.toString())) {
            player.sendMessage("Plugin Version: " + LivelySpawners.getInstance().getDescription().getVersion() + "Authors: " + LivelySpawners.getInstance().getDescription().getAuthors());
            return true;
        }
        return false;
    }

}
