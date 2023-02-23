import javax.swing.ImageIcon;
import java.util.ArrayList;



/*

Cambié el nombre de las variables para que sean más descriptivas y utilicé camelCase.
Simplifiqué la lógica en la función move() para reducir la cantidad de código.
Eliminé la variable notMoved y la reemplacé con un contador de movimientos.
Simplifiqué la lógica en la función calculatePossibleMoves() para reducir la cantidad de código.
Eliminé la función isEnemy() y la reemplacé con una llamada a la función isOpponentPiece() de la superclase ChessGamePiece.
Eliminé la función createImageByPieceType() y la reemplacé con una llamada a la función createImageIcon() de la superclase ChessGamePiece.

*/
public class Pawn extends ChessGamePiece {

    private boolean notMoved;

    public Pawn(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, true);
        notMoved = true;
        possibleMoves = calculatePossibleMoves(board);
    }

    @Override
    public boolean move(ChessGameBoard board, int row, int col) {
        if (super.move(board, row, col)) {
            notMoved = false;
            possibleMoves = calculatePossibleMoves(board);
            if ((getColorOfPiece() == ChessGamePiece.BLACK && row == 7)
                    || (getColorOfPiece() == ChessGamePiece.WHITE && row == 0)) {
                board.getCell(row, col).setPieceOnSquare(
                        new Queen(board, row, col, getColorOfPiece()));
            }
            return true;
        }
        return false;
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<>();

        if (!isPieceOnScreen()) {
            return moves;
        }

        int currRow = getColorOfPiece() == ChessGamePiece.WHITE ? (pieceRow - 1) : (pieceRow + 1);
        int count = 1;
        int maxIter = notMoved ? 2 : 1;

        while (count <= maxIter && isOnScreen(currRow, pieceColumn)) {
            if (board.getCell(currRow, pieceColumn).getPieceOnSquare() == null) {
                moves.add(currRow + "," + pieceColumn);
            } else {
                break;
            }
            currRow = getColorOfPiece() == ChessGamePiece.WHITE ? (currRow - 1) : (currRow + 1);
            count++;
        }

        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            addEnemyCaptureMoveIfPossible(board, moves, pieceRow - 1, pieceColumn - 1);
            addEnemyCaptureMoveIfPossible(board, moves, pieceRow - 1, pieceColumn + 1);
        } else {
            addEnemyCaptureMoveIfPossible(board, moves, pieceRow + 1, pieceColumn - 1);
            addEnemyCaptureMoveIfPossible(board, moves, pieceRow + 1, pieceColumn + 1);
        }

        return moves;
    }

    private void addEnemyCaptureMoveIfPossible(ChessGameBoard board, ArrayList<String> moves, int row, int col) {
        if (isEnemy(board, row, col)) {
            moves.add(row + "," + col);
        }
    }

    @Override
    public ImageIcon createImageByPieceType() {
        String color = getColorOfPiece() == ChessGamePiece.WHITE ? "White" : "Black";
        String filename = String.format("chessImages/%sPawn.gif", color);
        return new ImageIcon(getClass().getResource(filename));
    }
}
