/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Frostalf
 */
public class LivelySpawners extends JavaPlugin {

    private static LivelySpawners instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    public static LivelySpawners getInstance() {
        return instance;
    }

}
