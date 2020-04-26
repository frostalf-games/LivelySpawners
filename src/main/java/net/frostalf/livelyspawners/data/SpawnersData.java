/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners.data;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.frostalf.livelyspawners.LivelySpawners;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author Frostalf
 */
public class SpawnersData {

    private LivelySpawners plugin = LivelySpawners.getInstance();
    private static SpawnersData instance;
    private File dataFile = new File(plugin.getDataFolder(), "spawners.yml");
    private YamlConfiguration data;

    private SpawnersData() {
        instance = this;
        loadData();
    }

    public void loadData() {
        File f = new File(plugin.getDataFolder(), "spawners.yml");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().log(Level.SEVERE, "{0}Could not create spawner.yml File!", ChatColor.RED);
                e.printStackTrace();
            }
        }
        dataFile = f;
        data = YamlConfiguration.loadConfiguration(f);
    }

    public YamlConfiguration getData() {
        return this.data;
    }


    public void saveData() {
        try {
            data.save(dataFile);
        } catch (IOException exception) {
            plugin.getLogger().warning("Failed to save data :(");
        }
    }

    public static SpawnersData getSpawnersDataInstance() {
        if (instance == null) {
            instance = new SpawnersData();
        }
        return instance;
    }

}
