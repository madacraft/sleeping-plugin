package org.madacraft.sleeping.vote.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.madacraft.sleeping.Sleeping;
import org.madacraft.sleeping.shared.abstracts.Loadable;
import org.madacraft.sleeping.shared.log.Log;
import org.madacraft.sleeping.vote.enums.Commands;

public class Vote extends Loadable implements CommandExecutor {
    private final Log logger = Log.LOGGER;

    public Vote (Sleeping plugin, Commands command) {
        super(plugin, command);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        this.logger.getLogger().info("Hello World {}", command.toString());
        return true;
    }
}
