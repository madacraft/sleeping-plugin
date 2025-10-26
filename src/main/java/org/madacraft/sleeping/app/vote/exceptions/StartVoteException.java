package org.madacraft.sleeping.app.vote.exceptions;

public class StartVoteException extends Exception {
    private final String message;

    public StartVoteException (String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
