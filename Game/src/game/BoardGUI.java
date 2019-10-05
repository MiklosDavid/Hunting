package game;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A játéktábla grafikus reprezentációját megvalósító osztály
 */
public class BoardGUI { 
    
    private JButton[][] buttons;                // a mezőkhöz rendelendő gombok
    private Board board;                        // a tábla objektum; a tábla adatait tartalmazza
    private JPanel boardPanel;                  // ez a panel tartalmazza a játékmezőket
    private boolean isT = true;
    private boolean isTClicked = false;
    private int selectedX;
    private int selectedY;
    private int MX;
    private int MY;
    private int rounds = 1;
    private GameGUI gameGUI;         
    
    /** Létrehoz egy játéktáblát, és a mezőket alapértékre állítja. */
      
    public BoardGUI(int boardSize, GameGUI gamegui) {
        board = new Board(boardSize);
        boardPanel = new JPanel();
       
        boardPanel.setLayout(new GridLayout(board.getBoardSize(), board.getBoardSize()));
        buttons = new JButton[board.getBoardSize()][board.getBoardSize()];
        for (int i = 0; i < board.getBoardSize(); ++i) {
            for (int j = 0; j < board.getBoardSize(); ++j) {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener(i, j, boardPanel, gamegui, boardSize));
                button.setPreferredSize(new Dimension(80, 40));
                if((i == 0 && j == 0) || (i == 0 && j == board.getBoardSize() - 1) || (i == board.getBoardSize() - 1 && j == 0) || (i == board.getBoardSize() - 1 && j == board.getBoardSize() - 1)){ 
                    button.setText("T");
                }else if(i == (board.getBoardSize()/2) && j == board.getBoardSize()/2){
                    MX = board.getBoardSize()/2;
                    MY = board.getBoardSize()/2;
                    button.setText("M");
                }
                buttons[i][j] = button;
                boardPanel.add(button);
                
            }
        }
        

    }    
    
     public JPanel getBoardPanel() {
        return boardPanel;
    } 
    
     /**Az osztály célja annak álltalános leirása, hogy mi történjen, ha egy játémezőre kattintunk.*/
        
     class ButtonListener implements ActionListener {

        private GameGUI gamegui;
        private int x, y, boardSize;
        private JPanel boardPanel;

        public ButtonListener(int x, int y, JPanel boardPanel, GameGUI gamegui, int boardSize) {
            this.x = x;
            this.y = y;
            this.boardSize = boardSize;
            this.boardPanel = boardPanel;
            this.gamegui = gamegui;
        }
        
         /**
         * Az 'ActionListener' interfészből implementált metódus, ami meghatározza, hogy mi történjen, ha a mezőre kattintunk */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = ((JButton)e.getSource());
            if(isT){
                if(!isTClicked){
                    if(button.getText().equals("T")){
                        selectedX = x;
                        selectedY = y;
                        isTClicked = true;
                    }
                }else{ 
                    /** Helyes lépés vizsgálata. (1-et fel v. le v. jobbra v. ballra) */
                    if(((absoluteValue(x - selectedX) == 1 && (y - selectedY) == 0) || (absoluteValue(y - selectedY) == 1 && (x - selectedX) == 0)) && (buttons[x][y].getText().equals(""))){
                        buttons[selectedX][selectedY].setText("");
                        buttons[x][y].setText("T");
                        if(isTWin()){
                            JOptionPane.showMessageDialog(null, "T won the game!", "Game over", JOptionPane.INFORMATION_MESSAGE);
                            gamegui.setFields(boardSize); 
                            gamegui.getFrame().setLocationRelativeTo(null);
                            
                        }
                        isT = false;
                        isTClicked = false;
                    }
                }
            }else{ 
                /** Helyes lépés vizsgálata. (1-et fel v. le v. jobbra v. ballra) */
                if(((absoluteValue(x - MX) == 1 && (y - MY) == 0) || (absoluteValue(y - MY) == 1 && (x - MX) == 0)) && (buttons[x][y].getText().equals(""))){
                    buttons[MX][MY].setText("");
                    buttons[x][y].setText("M");
                    MX = x;
                    MY = y;
                    isT = true;
                    if(isMWin()){
                        JOptionPane.showMessageDialog(null, "M won the game!", "Game over", JOptionPane.INFORMATION_MESSAGE);
                        gamegui.setFields(boardSize); 
                        gamegui.getFrame().setLocationRelativeTo(null);
                    }
                    rounds++;
                    gamegui.getFrame().setTitle("Hunting Game round: " + rounds);
                }
            }
        }
        /** A "W" játékos nyerésének a feltétele */
        private boolean isTWin(){
            if((MX - 1 < 0 || buttons[MX - 1][MY].getText().equals("T")) && 
               (MX + 1 >= buttons.length || buttons[MX + 1][MY].getText().equals("T")) && 
               (MY - 1 < 0 || buttons[MX][MY - 1].getText().equals("T")) && 
               (MY + 1 >= buttons[MX].length || buttons[MX][MY + 1].getText().equals("T")))  
               return true;
            
            else return false;
        }
        /** A "T" játékos nyerésének a feltétele */
        private boolean isMWin(){
            return rounds == 4*boardSize;
        }
        
        private int absoluteValue(int num){
            if(num >= 0) return num;
            else return num*-1;
        } 
        
        

 
    }
    
}
