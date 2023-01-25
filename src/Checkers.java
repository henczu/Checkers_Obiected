import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Checkers implements MouseListener{
    private static int oldI, oldJ, beatenI, beatenJ;
    private static boolean playerWhiteTurn =true;
     static boolean fullTurn = true;
    private static boolean wasBeaten=false;

    Checkers(){
        Board board = new Board(this); //creating board

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (e.getSource() == Board.board[i][j].button) {
                    check(i,j);

                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public  void check(int i, int j){

        if(fullTurn) {
            if(Board.board[i][j].figures==null)return;
            if(!isWasBeaten()){
                oldI = i;
                oldJ = j;
                Board.board[i][j].figures.firstStepOfMove(i, j);

            }
            if(isWasBeaten() && (i==oldI && j==oldJ)) {
                Board.board[i][j].figures.firstStepOfMove(i, j);
            }
            return;
        }
        if(i==oldI && j == oldJ) {
            fullTurn = true;
            Board.board[oldI][oldJ].button.setBackground(new Color(255, 229, 180));
        }
        if(!fullTurn) {
            if(Board.board[i][j].figures!=null) return;

            Board.board[oldI][oldJ].figures.secondStepOfMove(i, j);
            if(Board.board[i][j].figures!=null) {
                Board.board[i][j].figures.makingKing(i, j);
            }
        }
        winningCheck();
    }
    private void winningCheck(){
        if(whiteWinningCheck()){
            Board.textfield.setText("Congratulations!!! White wins!!!");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Board.board[i][j].button.setBackground(Color.WHITE);
                }
            }
        }
        if(blackWinningCheck()){
            Board.textfield.setText("Congratulations!!! Black wins!!!");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Board.board[i][j].button.setBackground(Color.BLACK);
                }
            }
        }

    }
    private boolean whiteWinningCheck(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Board.board[i][j].figures != null && Board.board[i][j].figures.color.equals("Black")) return false;
            }
        }
        return true;
    }
    private boolean blackWinningCheck(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Board.board[i][j].figures != null && Board.board[i][j].figures.color.equals("White")) return false;
            }
        }
        return true;
    }

    public static int getOldI() {
        return oldI;
    }

    public static void setOldI(int oldI) {
        Checkers.oldI= oldI;
    }

    public static int getOldJ() {
        return oldJ;
    }

    public static void setOldJ(int oldJ) {
        Checkers.oldJ = oldJ;
    }

    public static boolean isPlayerWhiteTurn() {
        return playerWhiteTurn;
    }

    public static void setPlayerWhiteTurn(boolean playerWhiteTurn) {
        Checkers.playerWhiteTurn = playerWhiteTurn;
    }

    public static boolean isWasBeaten() {
        return wasBeaten;
    }

    public static void setWasBeaten(boolean wasBeaten) {
         Checkers.wasBeaten =wasBeaten;
    }

    public static int getBeatenI() {
        return beatenI;
    }

    public static void setBeatenI(int beatenI) {
        Checkers.beatenI = beatenI;
    }

    public static int getBeatenJ() {
        return beatenJ;
    }

    public static void setBeatenJ(int beatenJ) {
        Checkers.beatenJ = beatenJ;
    }
}
