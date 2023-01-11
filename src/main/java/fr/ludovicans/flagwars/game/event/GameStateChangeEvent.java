package fr.ludovicans.flagwars.game.event;

import fr.ludovicans.flagwars.game.GameInstance;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class GameStateChangeEvent extends Event {

    private static final @NotNull HandlerList handlerList = new HandlerList();

    private final @NotNull GameInstance gameInstance;
    private final @NotNull GameInstance.State oldState;
    private final @NotNull GameInstance.State newState;

    public GameStateChangeEvent(@NotNull final GameInstance gameInstance,
                                @NotNull final GameInstance.State oldState,
                                @NotNull final GameInstance .State newState) {
        this.gameInstance = gameInstance;
        this.oldState = oldState;
        this.newState = newState;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlerList;
    }

    public @NotNull GameInstance getGameInstance() {
        return gameInstance;
    }

    public @NotNull GameInstance.State getOldState() {
        return oldState;
    }

    public @NotNull GameInstance.State getNewState() {
        return newState;
    }
}
