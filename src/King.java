import java.awt.*;

public class King extends Figures{
    King(String color){
    this.color = color;
    }

    public void secondStepOfMove(int i, int j){

        if(!Checkers.isWasBeaten() && justKingMove(i,j)) {
            move(i,j);
        }
        beat(i, j,1,1) ;
        beat(i, j,-1,-1) ;
        beat(i, j,1,-1) ;
        beat(i, j,-1,1);

        longBeat(i,j);

//        if( Checkers.isPlayerWhiteTurn() && !Checkers.isWasBeaten() ) Checkers.setPlayerWhiteTurn(false);
//        else if(!Checkers.isPlayerWhiteTurn() && !Checkers.isWasBeaten() ) Checkers.setPlayerWhiteTurn(true);

    }
    private boolean justKingMove(int i, int j){

        if (Math.abs(Checkers.getOldI() - i) != Math.abs(Checkers.getOldJ() -j)) return false;
        if(    ((i==Checkers.getOldI()-1 && j==Checkers.getOldJ() -1) ||
                (i==Checkers.getOldI()-1 && j==Checkers.getOldJ() +1)) ||
                (i==Checkers.getOldI()+1 && j==Checkers.getOldJ() +1) ||
                (i==Checkers.getOldI()+1 && j==Checkers.getOldJ() -1)  ) return true;

            if ((i > Checkers.getOldI()) && (j > Checkers.getOldJ())) {
                for (int k = 1; k < (i - Checkers.getOldI()); k++) {

                    if ((Board.board[Checkers.getOldI() + k][Checkers.getOldJ() + k].figures != null)) return false; //sprawdzamy czy pola sa puste
                }
                return true;
            }
            if ((i > Checkers.getOldI()) && (j < Checkers.getOldJ())) {

                for (int k = 1; k < (i - Checkers.getOldI()); k++) {
                    if ((Board.board[Checkers.getOldI() + k][Checkers.getOldJ() - k].figures != null)) return false; //sprawdzamy czy pola sa puste
                }
                return true;
            }
            if ((i < Checkers.getOldI()) && (j > Checkers.getOldJ())) {

                for (int k = 1; k < (j - Checkers.getOldJ()); k++) {
                    if ((Board.board[Checkers.getOldI() - k][Checkers.getOldJ() + k].figures != null)) return false; //sprawdzamy czy pola sa puste
                }
                return true;
            }
            if ((i < Checkers.getOldI()) && (j < Checkers.getOldJ())) {

                for (int k = 1; k < (Checkers.getOldI() - i); k++) {
                    if ((Board.board[Checkers.getOldI() - k][Checkers.getOldJ() - k].figures != null)) return false; //sprawdzamy czy pola sa puste
                }
                return true;
            }


        return false;
    }
    private void longBeat(int i, int j){ // bicie krolowej
        if(Checkers.isPlayerWhiteTurn()) {
            if ((i > Checkers.getOldI()) && (j > Checkers.getOldJ())) {

                for (int k = 1; k < (i - Checkers.getOldI()-1); k++) {
                    if (!(Board.board[Checkers.getOldI() + k][Checkers.getOldJ() + k].figures == null)) return; //sprawdzamy czy pola sa puste jak nie sa to leci false
                }
                if (Board.board[i -1][j -1].figures!=null && Board.board[i -1][j -1].figures.color.equals("Black") ) {// check czy poprzednie pole jest przeciwnika
                    Checkers.setBeatenI(i - 1);
                    Checkers.setBeatenJ(j - 1);
                    whitePoints++;
                    Checkers.setWasBeaten(true);
                    move(i,j);                }
            }
            if ((i > Checkers.getOldI()) && (j < Checkers.getOldJ())) {

                for (int k = 1; k < (i - Checkers.getOldI()-1); k++) {
                    if (!(Board.board[Checkers.getOldI() + k][Checkers.getOldJ() - k].figures == null)) return ; //sprawdzamy czy pola sa puste jak nie sa to leci false
                }
                if (Board.board[i -1][j +1].figures != null && Board.board[i -1][j +1].figures.color.equals("Black") ) {// check czy poprzednie pole jest przeciwnika
                    Checkers.setBeatenI(i - 1);
                    Checkers.setBeatenJ(j + 1);
                    whitePoints++;
                    Checkers.setWasBeaten(true);
                    move(i,j);
                }
            }
            if ((i < Checkers.getOldI()) && (j > Checkers.getOldJ())) {

                for (int k = 1; k < (j - Checkers.getOldJ()-1); k++) {
                    if (!(Board.board[Checkers.getOldI() - k][Checkers.getOldJ() + k].figures == null)) return ; //sprawdzamy czy pola sa puste jak nie sa to leci false
                }
                if (Board.board[i +1][j -1].figures != null &&  Board.board[i +1][j -1].figures.color.equals("Black") ) {// check czy poprzednie pole jest przeciwnika
                    Checkers.setBeatenI(i + 1);
                    Checkers.setBeatenJ(j - 1);
                    whitePoints++;
                    Checkers.setWasBeaten(true);
                    move(i,j);                }
            }
            if ((i < Checkers.getOldI()) && (j < Checkers.getOldJ())) {

                for (int k = 1; k < (Checkers.getOldI() - i-1); k++) {
                    if (!(Board.board[Checkers.getOldI() - k][Checkers.getOldJ() - k].figures == null)) return ; //sprawdzamy czy pola sa puste jak nie sa to leci false
                }
                if (Board.board[i +1][j +1].figures !=null && Board.board[i +1][j +1].figures.color.equals("Black") ) {// check czy poprzednie pole jest przeciwnika
                    Checkers.setBeatenI(i + 1);
                    Checkers.setBeatenJ(j + 1);
                    whitePoints++;
                    Checkers.setWasBeaten(true);
                    move(i,j);                }
            }
        }
        if(!Checkers.isPlayerWhiteTurn()) {
            if ((i > Checkers.getOldI()) && (j > Checkers.getOldJ())) {

                for (int k = 1; k < (i - Checkers.getOldI()-1); k++) {
                    if (!(Board.board[Checkers.getOldI() + k][Checkers.getOldJ() + k].figures == null)) return ; //sprawdzamy czy pola sa puste jak nie sa to leci false
                }
                if (Board.board[i -1][j -1].figures != null &&  Board.board[i -1][j -1].figures.color.equals("White") ) {// check czy poprzednie pole jest przeciwnika
                    Checkers.setBeatenI(i - 1);
                    Checkers.setBeatenJ(j - 1);
                    blackPoints++;
                    Checkers.setWasBeaten(true);
                    move(i,j);
                }
            }
            if ((i > Checkers.getOldI()) && (j < Checkers.getOldJ())) {

                for (int k = 1; k < (i - Checkers.getOldI()-1); k++) {
                    if (!(Board.board[Checkers.getOldI() + k][Checkers.getOldJ() - k].figures == null)) return ; //sprawdzamy czy pola sa puste jak nie sa to leci false
                }
                if (Board.board[i -1][j +1].figures != null && Board.board[i -1][j +1].figures.color.equals("White") ) {// check czy poprzednie pole jest przeciwnika
                    Checkers.setBeatenI(i - 1);
                    Checkers.setBeatenJ(j + 1);
                    blackPoints++;
                    Checkers.setWasBeaten(true);
                    move(i,j);
                }
            }
            if ((i < Checkers.getOldI()) && (j > Checkers.getOldJ())) {

                for (int k = 1; k < (j - Checkers.getOldJ()-1); k++) {
                    if (!(Board.board[Checkers.getOldI() - k][Checkers.getOldJ() + k].figures == null)) return ; //sprawdzamy czy pola sa puste jak nie sa to leci false
                }
                if (Board.board[i +1][j -1].figures != null && Board.board[i +1][j -1].figures.color.equals("White") ) {// check czy poprzednie pole jest przeciwnika
                    Checkers.setBeatenI(i + 1);
                    Checkers.setBeatenJ(j - 1);
                    blackPoints++;
                    Checkers.setWasBeaten(true);
                    move(i,j);
                }
            }
            if ((i < Checkers.getOldI()) && (j < Checkers.getOldJ())) {

                for (int k = 1; k < (Checkers.getOldI() - i-1); k++) {
                    if (!(Board.board[Checkers.getOldI() - k][Checkers.getOldJ() - k].figures == null)) return ; //sprawdzamy czy pola sa puste jak nie sa to leci false
                }
                if (Board.board[i +1][j +1].figures != null && Board.board[i +1][j +1].figures.color.equals("White") ) {// check czy poprzednie pole jest przeciwnika
                    Checkers.setBeatenI( i + 1);
                    Checkers.setBeatenJ(j + 1);
                    blackPoints++;
                    Checkers.setWasBeaten(true);
                    move(i,j);
                }
            }
        }
    }


}
