import java.awt.*;

public abstract class Figures extends Board{
        String color;

        public Figures(String color) {
                this.color = color;
        }
        public Figures() {
           //     this.color = color;
        }

        public void firstStepOfMove(int i, int j) {
                if (Checkers.isPlayerWhiteTurn() && Board.board[i][j].figures.color.equals("White")) {
                        Board.board[i][j].button.setBackground(new Color(250, 200, 100));
                        Checkers.fullTurn=false;
                }
                if (!Checkers.isPlayerWhiteTurn() && Board.board[i][j].figures.color.equals("Black")) {
                        Board.board[i][j].button.setBackground(new Color(250, 200, 100));
                        Checkers.fullTurn=false;
                }
        }

        public void writingCurrentPoints(){
                textfield.setFont(new Font("Times New Roman", Font.BOLD, 45));

                textfield.setText("White points: " + whitePoints + "    Black points: " + blackPoints);


        }
        public void secondStepOfMove(int i, int j){

        }
//
        public void move(int i, int j){
                Board.board[i][j].button.setIcon(Board.board[Checkers.getOldI()][Checkers.getOldJ()].button.getIcon()); // nakladam nowa ikone

                Board.board[Checkers.getOldI()][Checkers.getOldJ()].button.setIcon(null); //czyszczę pole z ikony
                Board.board[Checkers.getOldI()][Checkers.getOldJ()].button.setBackground(new Color(255, 229, 180)); // czyszcze pole z zaznaczenia

                Board.board[i][j].figures =Board.board[Checkers.getOldI()][Checkers.getOldJ()].figures; // nakladam nowa referencje
                Board.board[Checkers.getOldI()][Checkers.getOldJ()].figures=null; // czyszcze poprzednia referencje

                writingCurrentPoints();
                System.out.println("jestem");
                Checkers.fullTurn=true;

                //makingKing(i, j);

                //Checkers.winningCheck();
                // reszta dla opcji przy biciu
                if(!Checkers.isWasBeaten()) return;

                System.out.println("no bylo bicie");
                Board.board[Checkers.getBeatenI()][Checkers.getBeatenJ()].figures=null; // czyszcze referencje zbitego pionka
                Board.board[Checkers.getBeatenI()][Checkers.getBeatenJ()].button.setIcon(null);
                if (possibleBeat(i,j)) {
                        Checkers.setOldI(i);
                        Checkers.setOldJ(j);
                        if (Checkers.isPlayerWhiteTurn()) {
                                Checkers.setPlayerWhiteTurn(true);


                        } else if (!Checkers.isPlayerWhiteTurn()) {
                                Checkers.setPlayerWhiteTurn(false);
                        }

                }
                else {
                        if (Checkers.isPlayerWhiteTurn()) {
                                Checkers.setPlayerWhiteTurn(false);

                        }
                        else if (!Checkers.isPlayerWhiteTurn()) {
                                Checkers.setPlayerWhiteTurn(true);
                        }
                        Checkers.setWasBeaten(false);
                }


        }
        protected void beat(int i, int j, int x, int y) {
                if(    !Checkers.isPlayerWhiteTurn() &&
                        i == Checkers.getOldI() + (2*x) && j == Checkers.getOldJ() + (2*y) &&
                        Board.board[Checkers.getOldI() + x][Checkers.getOldJ() + y].figures!=null && //?? moze by to?
                        (Board.board[Checkers.getOldI() + x][Checkers.getOldJ() + y].figures.color.equals("White") ))
                {
                        Checkers.setBeatenI(Checkers.getOldI()+ x);
                        Checkers.setBeatenJ(Checkers.getOldJ()+ y);
                        blackPoints++;
                        Checkers.setWasBeaten(true);
//            Checkers.setPlayerWhiteTurn(true);
                        System.out.println("bicie");
                        move(i,j);
                }
                else if (     Checkers.isPlayerWhiteTurn()  &&
                        i == Checkers.getOldI() + (2*x) && j == Checkers.getOldJ() + (2*y) &&
                        Board.board[Checkers.getOldI() + x][Checkers.getOldJ() + y].figures!=null &&
                        (Board.board[Checkers.getOldI() + x][Checkers.getOldJ() + y].figures.color.equals("Black") ))
                {
                        Checkers.setBeatenI(Checkers.getOldI() + x);
                        Checkers.setBeatenJ(Checkers.getOldJ()+ y);
                        whitePoints++;
                        Checkers.setWasBeaten(true);
                        System.out.println("bicie");

//            Checkers.setPlayerWhiteTurn(false);
                        move(i,j);
                }
        }
        private boolean possibleBeat( int newX, int newY) {
                System.out.println("possibility beat 1");
                if (Checkers.isPlayerWhiteTurn() && (
                                possibleBeat(newX, newY, -1, -1, "Black") ||
                                possibleBeat(newX, newY, +1, +1, "Black") ||
                                possibleBeat(newX, newY, -1, +1, "Black") ||
                                possibleBeat(newX, newY, +1, -1, "Black")
                )) {
                        return true;
                }
                else if (!Checkers.isPlayerWhiteTurn() && (
                                possibleBeat(newX, newY, -1, -1, "White") ||
                                possibleBeat(newX, newY, +1, +1, "White") ||
                                possibleBeat(newX, newY, -1, +1, "White") ||
                                possibleBeat(newX, newY, +1, -1, "White")
                )) {
                        return true;
                }
                else return false;
        }
        private boolean possibleBeat( int newX, int newY,int x, int y, String color){
                System.out.println("possibility beat 2");
                boolean tmp = false;
                try {
                        if ( (Board.board[newX + (2 * x)][newY + (2 * y)].figures==null) && (Board.board[newX + x][newY + y].figures!=null) && (Board.board[newX + x][newY + y].figures.color.equals(color)) ) {
                                tmp = true;
                        }
                        else tmp = false;
                }
                catch (ArrayIndexOutOfBoundsException e){
                        tmp=false;
                }
                System.out.println("czy possibility jest true    =  " + tmp);
                System.out.println(" newx " + newX + " newy " + newY + " x " + x + " y " + y );
                return  tmp;
        }
//        private void makingKing( int i, int j){
//                if(i==0 && Board.board[i][j].figures.color.equals("Black")){
//                        System.out.println(                        Board.board[i][j].button.getIcon());
//                        Board.board[i][j].button.setIcon(null);
//                        Board.board[i][j].button.setIcon(ico_black_queen);
//                        System.out.println(                        Board.board[i][j].button.getIcon());
//                        Board.board[i][j].figures =  new King("Black");
//
//                        textfield.setText("Congratulation!!! You have a King!");
//
//                }
//                if(i==7 && Board.board[i][j].figures.color.equals("White")){
//                        System.out.println(                        Board.board[i][j].button.getIcon());
//                        Board.board[i][j].button.setIcon(null);
//                        Board.board[i][j].button.setIcon(ico_white_queen);
//                        System.out.println(                        Board.board[i][j].button.getIcon());
//                        Board.board[i][j].figures =  new King("White");
//
//                        textfield.setText("Congratulation!!! You have a King!");
//
//                }
//
//
//        }
void makingKing( int i, int j){}



}
