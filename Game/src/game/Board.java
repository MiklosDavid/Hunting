package game;



/** A játéktábla adatait és logikáját reprezentáló osztály tartalmazza a játékmezőket, és a tábla méretét */
public class Board { 
    
    private Field[][] board;
    private final int boardSize; 
    
    /** Konstruktor, amely létrehozza egy tábla adatait a megadott táblaméret alapján.*/
      public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new Field[this.boardSize][this.boardSize];
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                board[i][j] = new Field();
            }
        }
    }
    
 
    
    public int getBoardSize() {
        return boardSize;
    }
}
