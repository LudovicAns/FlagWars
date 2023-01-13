package fr.ludovicans.flagwars.game;

import fr.ludovicans.flagwars.FlagWars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Cette classe permet de gérer les PNJ en jeu.
 */
@SuppressWarnings("unused")
public final class GamePNJ implements Listener {

    private final @NotNull Location location;
    private final @Nullable String displayname;

    public GamePNJ(@NotNull Location location, @Nullable String displayname) {
        this.location = location;
        this.displayname = displayname;

        Bukkit.getServer().getPluginManager().registerEvents(this, FlagWars.getINSTANCE());
    }

    // Todo: custom trades

}
