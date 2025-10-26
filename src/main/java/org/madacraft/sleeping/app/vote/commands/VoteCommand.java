package org.madacraft.sleeping.app.vote.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.madacraft.sleeping.Sleeping;
import org.madacraft.sleeping.app.shared.abstracts.Loadable;
import org.madacraft.sleeping.app.vote.enums.Commands;
import org.madacraft.sleeping.app.vote.services.Vote;

import javax.inject.Inject;

public class VoteCommand extends Loadable implements CommandExecutor {
    private final Vote voteService;

    @Inject
    public VoteCommand(Vote voteService) {
        super(Sleeping.getPlugin(), Commands.YES);
        this.voteService = voteService;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (this.voteService.isStarted()) {
            this.voteService.vote();
            this.plugin.getServer().broadcastMessage(String.format("%s vote 'Eny'", commandSender.getName()));
            return true;
        }
        this.plugin.getServer().broadcastMessage("You cannot vote if no player has started a vote");
        return false;
    }
}
