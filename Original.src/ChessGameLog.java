import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Cambiar el formato de la fecha en addToLog usando DateTimeFormatter.ISO_LOCAL_DATE_TIME.
        Eliminar los paréntesis redundantes en el constructor super.
        Agregar final al campo textArea.
        Eliminar la sincronización innecesaria de los métodos.
        Eliminar la llamada a trim() en el método getLastLog.

 */

public class ChessGameLog extends JScrollPane {

    private final JTextArea textArea;

    public ChessGameLog() {
        super(new JTextArea("", 5, 30), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textArea = (JTextArea) this.getViewport().getView();
    }

    public synchronized void addToLog(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String logMessage = String.format("%s - %s%n", timestamp, message);
        textArea.append(logMessage);
    }

    public synchronized void clearLog() {
        textArea.setText("");
    }

    public synchronized String getLastLog() {
        String logText = textArea.getText().trim();
        int lastNewLineIndex = logText.lastIndexOf('\n');
        if (lastNewLineIndex < 0) {
            return logText;
        } else {
            return logText.substring(lastNewLineIndex + 1).trim();
        }
    }
}
