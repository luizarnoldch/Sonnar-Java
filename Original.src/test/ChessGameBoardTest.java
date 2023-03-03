import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChessGameBoardTest {
    private ChessGameBoard board;
    
    @Before
    public void setUp() {
        board = new ChessGameBoard();
    }
    
    @Test
    public void testGetCell() {
        BoardSquare cell = board.getCell(0, 0);
        assertNotNull(cell);
        assertEquals(0, cell.getRow());
        assertEquals(0, cell.getColumn());
    }

    @Test
    public void testGetCellExists() {
        // Test  una celda que exista
        BoardSquare cell = board.getCell(0, 0);
        assertNotNull(cell);
    }

    @Test
    public void testGetCellNotExists() {
        // Test  una celda que no exista
        BoardSquare cell = board.getCell(-1, -1);
        assertNull(cell);
    }
}