package org.madacraft.sleeping.shared.abstracts;

import org.bukkit.command.CommandExecutor;
import org.madacraft.sleeping.Sleeping;
import org.madacraft.sleeping.shared.log.Log;
import org.madacraft.sleeping.vote.enums.Commands;

public abstract class Loadable implements CommandExecutor {
    protected final Sleeping plugin;
    private Commands command;
    private final Log logger = Log.LOGGER;

    public Loadable(Sleeping plugin, Commands command) {
        this.plugin = plugin;
        this.command = command;
    }

    public void load() {
        var command = this.plugin.getCommand(this.command.toString());
        if (command != null) {
            command.setExecutor(this);
            this.logger.getLogger().info("/{} loaded", this.command);
        } else {
            this.logger.getLogger().error("/{} not found", this.command);
        }
    }
}
