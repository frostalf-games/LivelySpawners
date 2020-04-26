/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners;

import java.util.concurrent.ConcurrentHashMap;
import net.frostalf.livelyspawners.data.SpawnersData;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Frostalf
 */
public class LivelySpawners extends JavaPlugin {

    private ConcurrentHashMap<Location, SpawnersBlock> spawnersMap;
    private SpawnersData spawnerData;

    private static LivelySpawners instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        spawnersMap = new ConcurrentHashMap();
        spawnerData = SpawnersData.getSpawnersDataInstance();
    }

    public void getCache() {
    }

    public SpawnersData getSpawnersData() {
        return this.spawnerData;
    }

    public ConcurrentHashMap<Location, SpawnersBlock> getSpawnersMap() {
        return this.spawnersMap;
    }

    public static LivelySpawners getInstance() {
        return instance;
    }

    private void init() {
        if (getSpawnersData().getData().getConfigurationSection("spawners") != null) {
            for (String spawners : getSpawnersData().getData().getConfigurationSection("spawners").getKeys(false)) {
                int spawnerID = Integer.parseInt(spawners);
            }
        }
    }

}
