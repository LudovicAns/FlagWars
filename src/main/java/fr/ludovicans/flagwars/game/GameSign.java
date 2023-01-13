package fr.ludovicans.flagwars.game;

import org.bukkit.block.Sign;
import org.jetbrains.annotations.NotNull;

public final class GameSign {

    @NotNull private final String id;

    @NotNull private Sign sign;

    @NotNull private final GameInstance gameInstance;

    public GameSign(@NotNull final String id, @NotNull Sign sign, @NotNull final GameInstance gameInstance) {
        this.id = id;
        this.sign = sign;
        this.gameInstance = gameInstance;
    }

    @NotNull
    public String getId() {
        return id;
    }

    @NotNull
    public Sign getSign() {
        return sign;
    }

    public void setSign(@NotNull final Sign sign) {
        this.sign = sign;
    }

    @NotNull
    public GameInstance getGameInstance() {
        return gameInstance;
    }

    public boolean isGameSign(final @NotNull Sign sign) {
        return this.sign.equals(sign);
    }
}
