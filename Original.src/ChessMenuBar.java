import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * El código fue refactorizado para hacerlo más legible y fácil de entender.
 * Se crearon métodos separados para cada acción que se realiza al presionar un
 * botón en la barra de menú, lo que facilita la modificación y el mantenimiento
 * del código. También se eliminaron los comentarios innecesarios para hacer el código más limpio.
 */
public class ChessMenuBar extends JMenuBar {

    private static final long serialVersionUID = 1L;

    private static final String[] MENU_CATEGORIES = {"File", "Options", "Help"};
    private static final String[][] MENU_ITEM_LISTS = {
            {"New game/restart", "Exit"},
            {"Toggle graveyard", "Toggle game log"},
            {"About"}
    };

    public ChessMenuBar() {
        createMenus();
    }

    private void createMenus() {
        for (int i = 0; i < MENU_CATEGORIES.length; i++) {
            JMenu menu = new JMenu(MENU_CATEGORIES[i]);
            for (int j = 0; j < MENU_ITEM_LISTS[i].length; j++) {
                JMenuItem item = new JMenuItem(MENU_ITEM_LISTS[i][j]);
                item.addActionListener(new MenuListener());
                menu.add(item);
            }
            this.add(menu);
        }
    }

    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String buttonName = ((JMenuItem) event.getSource()).getText();
            switch (buttonName) {
                case "About":
                    aboutHandler();
                    break;
                case "New game/restart":
                    restartHandler();
                    break;
                case "Toggle game log":
                    toggleGameLogHandler();
                    break;
                case "Exit":
                    exitHandler();
                    break;
                default:
                    toggleGraveyardHandler();
                    break;
            }
        }
    }

    private void aboutHandler() {
        JOptionPane.showMessageDialog(this.getParent(),
                "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\nDanielle Bushrow\n\nFinal Project for CS2114 @ VT");
    }

    private void restartHandler() {
        ChessPanel panel = (ChessPanel) this.getParent();
        panel.getGameEngine().reset();
    }

    private void exitHandler() {
        JOptionPane.showMessageDialog(this.getParent(), "Thanks for leaving, quitter! >:(");
        Component possibleFrame = this;
        while (possibleFrame != null && !(possibleFrame instanceof JFrame)) {
            possibleFrame = possibleFrame.getParent();
        }
        JFrame frame = (JFrame) possibleFrame;
        frame.setVisible(false);
        frame.dispose();
    }

    private void toggleGraveyardHandler() {
        ChessPanel panel = (ChessPanel) this.getParent();
        panel.getGraveyard(1).setVisible(!panel.getGraveyard(1).isVisible());
        panel.getGraveyard(2).setVisible(!panel.getGraveyard(2).isVisible());
    }

    private void toggleGameLogHandler() {
        ChessPanel panel = (ChessPanel) this.getParent();
        panel.getGameLog().setVisible(!panel.getGameLog().isVisible());
        panel.revalidate();
    }

}