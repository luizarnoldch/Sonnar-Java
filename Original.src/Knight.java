import javax.swing.ImageIcon;
import java.util.ArrayList;
/*
Se eliminó el modificador de acceso public de los métodos calculateNorthMoves() y calculateSouthMoves(), ya que no se utilizan fuera de la clase Knight.
        Se cambió la visibilidad de las variables de instancia pieceRow y pieceColumn a protected, para poder acceder a ellas desde las subclases.
        Se modificó el método createImageByPieceType() para utilizar una variable local imagePath en lugar de repetir código en los tres casos.

*/
public class Knight extends ChessGamePiece {

    public Knight(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<String>();

        if (isPieceOnScreen()) {
            moves.addAll(calculateNorthMoves(board));
            moves.addAll(calculateSouthMoves(board));
        }

        return moves;
    }

    private ArrayList<String> calculateNorthMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<String>();

        for (int i = 2; i >= -2; i -= 4) {
            for (int j = 1; j >= -1; j -= 2) {
                if (isOnScreen(pieceRow + i, pieceColumn + j)
                        && (isEnemy(board, pieceRow + i, pieceColumn + j) ||
                        board.getCell(pieceRow + i, pieceColumn + j).getPieceOnSquare() == null)) {
                    moves.add((pieceRow + i) + "," + (pieceColumn + j));
                }
            }
        }

        return moves;
    }

    private ArrayList<String> calculateSouthMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<String>();

        for (int i = 1; i >= -1; i -= 2) {
            for (int j = 2; j >= -2; j -= 4) {
                if (isOnScreen(pieceRow + i, pieceColumn + j)
                        && (isEnemy(board, pieceRow + i, pieceColumn + j) ||
                        board.getCell(pieceRow + i, pieceColumn + j).getPieceOnSquare() == null)) {
                    moves.add((pieceRow + i) + "," + (pieceColumn + j));
                }
            }
        }

        return moves;
    }

    @Override
    public ImageIcon createImageByPieceType() {
        String imagePath = "chessImages/default-Unassigned.gif";

        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            imagePath = "chessImages/WhiteKnight.gif";
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            imagePath = "chessImages/BlackKnight.gif";
        }

        return new ImageIcon(getClass().getResource(imagePath));
    }
}
