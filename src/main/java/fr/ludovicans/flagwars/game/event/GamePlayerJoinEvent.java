package fr.ludovicans.flagwars.game.event;

import fr.ludovicans.flagwars.game.GameInstance;
import fr.ludovicans.flagwars.game.GamePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Appelé quand un {@link GamePlayer} rejoint une {@link GameInstance}.
 */
@SuppressWarnings("unused")
public final class GamePlayerJoinEvent extends Event {

    private static final @NotNull HandlerList handlerList = new HandlerList();

    private final @NotNull GameInstance gameInstance;
    private final @NotNull GamePlayer gamePlayer;

    public GamePlayerJoinEvent(@NotNull final GameInstance gameInstance, @NotNull final GamePlayer gamePlayer) {
        this.gameInstance = gameInstance;
        this.gamePlayer = gamePlayer;
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

    public @NotNull GamePlayer getGamePlayer() {
        return gamePlayer;
    }
}
