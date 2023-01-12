package fr.ludovicans.flagwars.game;

import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.index.qual.NonNegative;
import org.jetbrains.annotations.NotNull;

/**
 * {@link GameRessourceSpawner} permet de créer un spawner d'un item défini avec une quantité et un interval spécifique.
 * Ce spawner de ressources peut être activé ou désactivé avec {@link GameRessourceSpawner#setActivate(boolean)}.
 * <br />
 * Le drop s'active automatiquement en fonction du {@link GameInstance.State}:<br />
 * <ul>
 *     <li>{@link GameInstance.State#PREPARATION} : Activation</li>
 *     <li>{@link GameInstance.State#MAP_REGEN} : Désactivation</li>
 * </ul>
 */
@SuppressWarnings("unused")
public final class GameRessourceSpawner implements Listener {

    private final @NotNull GameInstance gameInstance;

    private final @NotNull Location dropLocation;
    private final @NotNull ItemStack dropedItem;
    private final @NonNegative int quantity;
    private final @NonNegative int interval; // secondes
    private boolean activate = false;

    public GameRessourceSpawner(@NotNull GameInstance gameInstance,
                                @NotNull final Location dropLocation,
                                @NotNull final ItemStack dropedItem,
                                final @NonNegative int quantity,
                                final @NonNegative int interval) {
        this.gameInstance = gameInstance;
        this.dropLocation = dropLocation;
        this.dropedItem = dropedItem;
        this.quantity = quantity;
        this.interval = interval;
    }

    public @NotNull GameInstance getGameInstance() {
        return gameInstance;
    }

    public @NotNull Location getDropLocation() {
        return dropLocation;
    }

    public @NotNull  ItemStack getDropedItem() {
        return dropedItem;
    }

    public @NonNegative int getQuantity() {
        return quantity;
    }

    public @NonNegative int getInterval() {
        return interval;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(final boolean activate) {
        this.activate = activate;
    }
}
