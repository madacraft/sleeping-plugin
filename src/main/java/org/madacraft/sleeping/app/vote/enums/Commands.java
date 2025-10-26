package org.madacraft.sleeping.app.vote.enums;

public enum Commands {
    VOTE,
    YES,
    NO;

    @Override
    public String toString() {
        switch (this) {
            case NO -> {
                return "hatory.tsia";
            }
            case YES  -> {
                return "hatory.eny";
            }
            case VOTE -> {
                return "hatory";
            }
        }
        return super.toString();
    }
}
