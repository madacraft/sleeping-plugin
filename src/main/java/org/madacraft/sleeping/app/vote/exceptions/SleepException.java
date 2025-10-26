package org.madacraft.sleeping.app.vote.exceptions;

public class SleepException extends Exception {
    @Override
    public String getMessage() {
        return "The sleeping vote is less than half player count";
    }
}
