package org.madacraft.sleeping.app.vote.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.madacraft.sleeping.Sleeping;
import org.madacraft.sleeping.app.vote.exceptions.SleepException;
import org.madacraft.sleeping.app.vote.services.Sleep;
import org.madacraft.sleeping.app.vote.services.Vote;
import org.madacraft.sleeping.app.shared.abstracts.Loadable;
import org.madacraft.sleeping.app.vote.enums.Commands;
import javax.inject.Inject;

public class CreateVoteCommand extends Loadable implements CommandExecutor {
    private final Vote voteService;
    private final Sleep sleepService;

    @Inject()
    public CreateVoteCommand(Vote voteService, Sleep sleepService) {
        super(Sleeping.getPlugin(), Commands.VOTE);
        this.voteService = voteService;
        this.sleepService = sleepService;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        var player = (Player) commandSender;
        var duration = Sleeping.getConfiguration().getDuration();
        Runnable closure = () -> this.sleep(player, this.voteService.getCount());

        if (this.voteService.newVote(Sleeping.getPlugin(), player)) {
            this.plugin.getServer().getScheduler().runTaskLater(this.plugin, closure, duration);
            return true;
        }
        return false;
    }

    private void sleep(Player sender, int votes) {
        try {
            this.sleepService.sleep(this.plugin, sender.getWorld(), votes);
            this.voteService.reinitialize();
        } catch (SleepException exception) {
            this.plugin.getServer().broadcastMessage(exception.getMessage());
        }
    }
}
