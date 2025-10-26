package org.madacraft.sleeping.app.vote.services;

import org.bukkit.entity.Player;
import org.madacraft.sleeping.Sleeping;
import org.madacraft.sleeping.app.vote.exceptions.StartVoteException;

import javax.inject.Inject;

public class Vote {
    private static boolean started = false;
    private static int count = 0;

    @Inject
    public Vote() {}

    public boolean newVote(Sleeping plugin, Player sender) {
        try {
            var world = sender.getWorld();
            this.verify(world.getTime());
            var raw = "%s starts a sleeping vote, the vote will end after %d seconds for %s";
            var msg = String.format(raw, sender.getName(), world.getTime(), world.getName());
            plugin.getServer().broadcastMessage(msg);
            started = true;
            return true;
        } catch (StartVoteException exception) {
            sender.sendMessage(exception.getMessage());
            return false;
        }
    }

    public  boolean isStarted() { return started; }

    public int getCount() { return count; }

    public void vote() { count++; }

    private boolean isNight(Long time) { return time > 12300 && time < 23850; }

    private void verify (long time) throws StartVoteException {
        if (!isNight(time)) throw new StartVoteException("You can only start sleeping vote at night");
        if (started) throw new StartVoteException("A vote request is already pending");
    }

    public void reinitialize() {
        started = false;
        count = 0;
    }
}
