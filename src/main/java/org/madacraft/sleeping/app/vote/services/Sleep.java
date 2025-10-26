package org.madacraft.sleeping.app.vote.services;

import org.apache.logging.log4j.util.Lazy;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.madacraft.sleeping.Sleeping;
import org.madacraft.sleeping.app.vote.exceptions.SleepException;

import javax.inject.Inject;

public class Sleep {
    @Inject
    public Sleep() {
    }

    public void sleep(Sleeping plugin, World world, int votes) throws SleepException {
        var players = world.getPlayers();
        plugin.getServer().broadcastMessage(String.format("Vote result: %d/%d", votes, players.size()));
        if (votes > (players.size() / 2)) {
            players.forEach(Player::resetPlayerTime);
            world.setTime(0);
        }
        throw new SleepException();
    }
}
