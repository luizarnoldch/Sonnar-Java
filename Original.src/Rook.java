import javax.swing.ImageIcon;
import java.util.ArrayList;



/*Se eliminó el campo comentado "movimientos posibles" ya que no se usó en la clase
Se eliminaron las variables locales innecesarias para cada dirección de movimientos y se combinaron en una sola ArrayList "allMoves"
Simplificó el método createImageByPieceType()
        para usar una sola variable de cadena para la ruta de la imagen y solo crear un nuevo objeto ImageIcon una vez al final del método.
*/

public class Rook extends ChessGamePiece {
    public Rook(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> allMoves = new ArrayList<>();

        allMoves.addAll(calculateNorthMoves(board, 8));
        allMoves.addAll(calculateSouthMoves(board, 8));
        allMoves.addAll(calculateWestMoves(board, 8));
        allMoves.addAll(calculateEastMoves(board, 8));

        return allMoves;
    }

    @Override
    public ImageIcon createImageByPieceType() {
        String path = "chessImages/default-Unassigned.gif";

        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            path = "chessImages/WhiteRook.gif";
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            path = "chessImages/BlackRook.gif";
        }

        return new ImageIcon(getClass().getResource(path));
    }

}