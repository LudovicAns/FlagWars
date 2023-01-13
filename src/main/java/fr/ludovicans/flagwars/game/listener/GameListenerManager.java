package fr.ludovicans.flagwars.game.listener;

import fr.ludovicans.flagwars.FlagWars;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

public final class GameListenerManager {

    public GameListenerManager(FlagWars plugin) {
        final @NotNull PluginManager pluginManager = plugin.getServer().getPluginManager();

        pluginManager.registerEvents(new GameListener(plugin), plugin);
    }
}
