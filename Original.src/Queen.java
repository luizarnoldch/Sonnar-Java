import javax.swing.ImageIcon;
import java.util.ArrayList;



/*Cambié el formato del código para hacerlo más legible.
        Eliminé comentarios innecesarios y código importado no utilizado.
        Simplifiqué el método calculatePossibleMoves.
        Modifiqué el método createImageByPieceType para hacerlo más legible.*/

public class Queen extends ChessGamePiece {
    /**
     * Create a new Queen object.
     *
     * @param board the board the queen is on
     * @param row the row location of the queen
     * @param col the column location of the queen
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Calculates the possible moves for this Queen.
     *
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> allMoves = new ArrayList<String>();

        allMoves.addAll(calculateNorthEastMoves(board, 8));
        allMoves.addAll(calculateNorthWestMoves(board, 8));
        allMoves.addAll(calculateSouthEastMoves(board, 8));
        allMoves.addAll(calculateSouthWestMoves(board, 8));
        allMoves.addAll(calculateNorthMoves(board, 8));
        allMoves.addAll(calculateSouthMoves(board, 8));
        allMoves.addAll(calculateEastMoves(board, 8));
        allMoves.addAll(calculateWestMoves(board, 8));

        return allMoves;
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        String path = "chessImages/default-Unassigned.gif";

        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            path = "chessImages/WhiteQueen.gif";
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            path = "chessImages/BlackQueen.gif";
        }

        return new ImageIcon(getClass().getResource(path));
    }

}
