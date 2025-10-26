package org.madacraft.sleeping.config;

import org.madacraft.sleeping.Sleeping;
import org.madacraft.sleeping.app.shared.log.Log;

import java.io.File;
import java.io.IOException;

public class Configuration {
    private Sleeping plugin;

    public Configuration (Sleeping plugin) {
        var logger = Log.LOGGER;
        try {
            var configFile = plugin.getDataFolder();
            if (!configFile.exists()) {
                var config = plugin.getConfig();
                config.set("duration", 60);
                if(!configFile.mkdirs()) throw new IOException();
                config.save(new File(configFile, "config.yml"));
            }
        } catch (Exception e) {
            logger.getLogger().warn("An error occured while loading config file");
        }
    }

    public Long getDuration () {
        return this.plugin.getConfig().getLong("duration");
    }
}
