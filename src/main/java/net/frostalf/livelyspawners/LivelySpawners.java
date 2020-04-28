/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import net.frostalf.livelyspawners.data.SpawnersData;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

/**
 *
 * @author Frostalf
 */
public class LivelySpawners extends JavaPlugin {

    private ConcurrentHashMap<Location, SpawnersBlock> spawnersMap;
    private List<String> spawnBlockLocations = new ArrayList<>();
    private SpawnersData spawnerData;

    private static LivelySpawners instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        spawnersMap = new ConcurrentHashMap();
        spawnerData = SpawnersData.getSpawnersDataInstance();
        init();
    }

    @Override
    public void onDisable() {
        for (SpawnersBlock spawners : getSpawnersMap().values()) {
            getSpawnersData().getData().set("spawners." + Base64Coder.encodeString(spawners.getSpawnerLocation().toString()), spawnBlockLocationList());
            getSpawnersData().getData().set("spawners." + Base64Coder.encodeString(spawners.getSpawnerLocation().toString() + ".lives"), spawners.getSpawnerLives());
        }
        getSpawnersData().saveData();
    }

    public void getCache() {
    }

    public SpawnersData getSpawnersData() {
        return this.spawnerData;
    }

    public List<String> spawnBlockLocationList() {
        return this.spawnBlockLocations;
    }

    public ConcurrentHashMap<Location, SpawnersBlock> getSpawnersMap() {
        return this.spawnersMap;
    }

    public static LivelySpawners getInstance() {
        return instance;
    }

    private void init() {
        if (getSpawnersData().getData().getConfigurationSection("spawners") != null) {
            for (String spawnerList : getSpawnersData().getData().getConfigurationSection("spawners").getKeys(false)) {
                String spawnersDecoded = Base64Coder.decodeString(spawnerList);
                String[] getLocationString = spawnersDecoded.split(",");
                World world = getServer().getWorld(getLocationString[0]);
                Location spawnerLocations = new Location(world, Double.parseDouble(getLocationString[1]), Double.parseDouble(getLocationString[2]), Double.parseDouble(getLocationString[3]));
                SpawnersBlock spawnBlock = new SpawnersBlock(spawnerLocations, getSpawnersData().getData().getInt(spawnerList + ".lives"));
                getSpawnersMap().put(spawnerLocations, spawnBlock);
                spawnBlockLocationList().add(spawnersDecoded);
            }
        }
    }

}
