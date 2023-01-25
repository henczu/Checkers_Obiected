import java.awt.*;

public class Man extends Figures {
    Man(String color) {
    this.color = color;
    }
    public void secondStepOfMove(int i, int j){

        System.out.println(Checkers.isWasBeaten());
        if(
                Checkers.isPlayerWhiteTurn() && !Checkers.isWasBeaten() &&
                ((i==Checkers.getOldI()+1 && j==Checkers.getOldJ() +1) ||
                (i==Checkers.getOldI()+1 && j==Checkers.getOldJ() -1))
        ) {
                move(i,j);
                Checkers.setPlayerWhiteTurn(false);
        }
        if(
                !Checkers.isPlayerWhiteTurn() && !Checkers.isWasBeaten() &&
                ((i==Checkers.getOldI()-1 && j==Checkers.getOldJ() -1) ||
                (i==Checkers.getOldI()-1 && j==Checkers.getOldJ() +1))
        ) {
                move(i,j);
                Checkers.setPlayerWhiteTurn(true);
        }
                beat(i, j,1,1) ;
                beat(i, j,-1,-1) ;
                beat(i, j,1,-1) ;
                beat(i, j,-1,1);

    }

     void makingKing( int i, int j){
        if(i==0 && Board.board[i][j].figures.color.equals("Black")){
            System.out.println(                        Board.board[i][j].button.getIcon());
            Board.board[i][j].button.setIcon(null);
            Board.board[i][j].button.setIcon(ico_black_queen);
            System.out.println(                        Board.board[i][j].button.getIcon());
            Board.board[i][j].figures =  new King("Black");

            textfield.setText("Congratulation!!! You have a King!");

        }
        if(i==7 && Board.board[i][j].figures.color.equals("White")){
            System.out.println(                        Board.board[i][j].button.getIcon());
            Board.board[i][j].button.setIcon(null);
            Board.board[i][j].button.setIcon(ico_white_queen);
            System.out.println(                        Board.board[i][j].button.getIcon());
            Board.board[i][j].figures =  new King("White");

            textfield.setText("Congratulation!!! You have a King!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}









