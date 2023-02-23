import java.awt.BorderLayout;
import javax.swing.JPanel;


/**
 Se han eliminado los import no utilizados.
 Se han eliminado los comentarios redundantes.
 Los miembros de clase se inicializan en la declaración y se han hecho finales.
 Se han eliminado los nombres de parámetros redundantes en los comentarios de los métodos.
 Se ha simplificado el método getGraveyard utilizando el operador ternario.
 */
public class ChessPanel extends JPanel {
    private final ChessMenuBar menuBar = new ChessMenuBar();
    private final ChessGameBoard gameBoard = new ChessGameBoard();
    private final ChessGameLog gameLog = new ChessGameLog();
    private final ChessGraveyard playerOneGraveyard = new ChessGraveyard("Player 1's graveyard");
    private final ChessGraveyard playerTwoGraveyard = new ChessGraveyard("Player 2's graveyard");
    private final ChessGameEngine gameEngine;

    // ----------------------------------------------------------
    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel() {
        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
        add(gameLog, BorderLayout.SOUTH);
        add(playerOneGraveyard, BorderLayout.WEST);
        add(playerTwoGraveyard, BorderLayout.EAST);
        setPreferredSize(new java.awt.Dimension(800, 600));
        gameEngine = new ChessGameEngine(gameBoard); // start the game
    }

    // ----------------------------------------------------------
    /**
     * Gets the logger object for use in other classes.
     *
     * @return the ChessGameLog object
     */
    public ChessGameLog getGameLog() {
        return gameLog;
    }

    // ----------------------------------------------------------
    /**
     * Gets the board object for use in other classes.
     *
     * @return the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard() {
        return gameBoard;
    }

    // ----------------------------------------------------------
    /**
     * Gets the game engine object for use in other classes.
     *
     * @return the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine() {
        return gameEngine;
    }

    // ----------------------------------------------------------
    /**
     * Gets the appropriate graveyard object for use in other classes.
     *
     * @param whichPlayer
     *            the number of the player (1 or 2)
     * @return the graveyard requested
     */
    public ChessGraveyard getGraveyard(int whichPlayer) {
        return (whichPlayer == 1) ? playerOneGraveyard : (whichPlayer == 2) ? playerTwoGraveyard : null;
    }
}
