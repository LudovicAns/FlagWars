package fr.ludovicans.flagwars.game;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Représente un {@link Player} en jeu dans une {@link GameInstance}.
 */
@SuppressWarnings("unused")
public final class GamePlayer {

    public enum State {
        ALIVE, DEAD, SPECTATE, DISCONNECTED
    }

    @NotNull private final Player player;

    // Game vars
    @NotNull private State state = State.ALIVE;
    private boolean carryFlag = false;

    // Stats
    private int deathCount = 0;
    private int flagPickedUpCount = 0;
    private int flagWonCount = 0;

    public GamePlayer(@NotNull final Player player) {
        this.player = player;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public State getState() {
        return state;
    }

    public void setState(@NotNull final State state) {
        this.state = state;
    }

    public boolean isCarryingFlag() {
        return carryFlag;
    }

    public void setCarryFlag(final boolean carryFlag) {
        this.carryFlag = carryFlag;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(final int deathCount) {
        this.deathCount = deathCount;
    }

    public int getFlagPickedUpCount() {
        return flagPickedUpCount;
    }

    public void setFlagPickedUpCount(final int flagPickedUpCount) {
        this.flagPickedUpCount = flagPickedUpCount;
    }

    public int getFlagWonCount() {
        return flagWonCount;
    }

    public void setFlagWonCount(final int flagWonCount) {
        this.flagWonCount = flagWonCount;
    }
}
