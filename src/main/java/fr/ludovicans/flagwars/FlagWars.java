package fr.ludovicans.flagwars;

import fr.ludovicans.flagwars.game.GameManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class FlagWars extends JavaPlugin {

    private static FlagWars INSTANCE;

    private GameManager gameManager;

    @Override
    public void onEnable() {
        INSTANCE = this;

        gameManager = new GameManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static FlagWars getINSTANCE() {
        return INSTANCE;
    }

    public @NotNull GameManager getGameManager() {
        return gameManager;
    }
}
