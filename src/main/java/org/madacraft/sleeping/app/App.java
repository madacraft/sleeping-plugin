package org.madacraft.sleeping.app;

import org.madacraft.sleeping.app.shared.abstracts.Loadable;
import org.madacraft.sleeping.app.vote.commands.CreateVoteCommand;
import org.madacraft.sleeping.app.vote.commands.VoteCommand;

import javax.inject.Inject;
import java.util.ArrayList;

public class App {
    private final ArrayList<Loadable> loadables = new ArrayList<>();

    @Inject
    public App(CreateVoteCommand createVoteCommand, VoteCommand voteCommand) {
        loadables.add(createVoteCommand);
        loadables.add(voteCommand);
    }

    public void load () {
        loadables.forEach(Loadable::load);
    }
}
