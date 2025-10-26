package org.madacraft.sleeping;

import org.bukkit.plugin.java.JavaPlugin;
import org.madacraft.sleeping.shared.abstracts.Loadable;
import org.madacraft.sleeping.shared.log.Log;
import org.madacraft.sleeping.vote.commands.Vote;
import org.madacraft.sleeping.vote.enums.Commands;

import java.util.ArrayList;

public final class Sleeping extends JavaPlugin {
    private final ArrayList<Loadable> loadables = new ArrayList<>();
    private final Log logger = Log.LOGGER;

    public Sleeping () {
        loadables.add(new Vote(this, Commands.VOTE));
    }

    @Override
    public void onEnable() {
        loadables.forEach(Loadable::load);
        this.logger.getLogger().info("Plugin Loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
