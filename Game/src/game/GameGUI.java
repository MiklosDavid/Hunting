package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/** A játék ablakát megjelenítő osztály; létrehozza a menüt, és a játéktáblát */
public class GameGUI { 
    
    private JFrame frame;
    private BoardGUI boardGUI;

    private final int INITIAL_BOARD_SIZE = 5; 
    
     public GameGUI() {
        frame = new JFrame("Hunting Game round: 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardGUI = new BoardGUI(INITIAL_BOARD_SIZE, this);
        frame.getContentPane().add(boardGUI.getBoardPanel(), BorderLayout.CENTER);
        

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenu newMenu = new JMenu("New");
        gameMenu.add(newMenu);
        int[] boardSizes = new int[]{3, 5, 7};
        for (int boardSize : boardSizes) {
            JMenuItem sizeMenuItem = new JMenuItem(boardSize + "x" + boardSize);
            newMenu.add(sizeMenuItem);
            sizeMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setFields(boardSize);
                }
            });
        }
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
     
     public JFrame getFrame(){
         return frame;
     }
     
     /** Új játékot indít a megadott táblaméret alapján. */
     public void setFields(int boardSize){
        frame.setTitle("Hunting Game round: 1");
        frame.getContentPane().remove(boardGUI.getBoardPanel());
        boardGUI = new BoardGUI(boardSize, this);
        frame.getContentPane().add(boardGUI.getBoardPanel(),BorderLayout.CENTER);
        frame.pack();
     }
    
}
