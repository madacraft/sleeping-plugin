package org.madacraft.sleeping;

import dagger.internal.DaggerCollections;
import org.bukkit.plugin.java.JavaPlugin;
import org.madacraft.sleeping.config.Configuration;
import org.madacraft.sleeping.app.shared.log.Log;

public final class Sleeping extends JavaPlugin {
    private final Log logger = Log.LOGGER;
    private static Sleeping instance;
    private static Configuration configuration;

    public Sleeping () { instance = this; }

    @Override
    public void onEnable() {
        configuration = new Configuration(this);
        AppFactory.create().app().load();
        this.logger.getLogger().info("Plugin Loaded");
    }

    public static Sleeping getPlugin() {
        return Sleeping.instance;
    }

    public static Configuration getConfiguration() {
        return Sleeping.configuration;
    }
}
