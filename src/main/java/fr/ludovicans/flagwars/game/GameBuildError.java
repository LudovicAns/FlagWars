package fr.ludovicans.flagwars.game;


/**
 * Cette erreur doit être levée si un problème survient lors de la construction d'un objet appartenant
 * au package {@link fr.ludovicans.flagwars.game}.
 */
public final class GameBuildError extends Exception {

    public GameBuildError(String message) {
        super(message);
    }
}
