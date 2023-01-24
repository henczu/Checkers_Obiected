import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board {
    // do pola dodaje button i przypisuje wartosc i sprawdzam pozniej czy cos tam jest
    Image img_black;
    Icon ico_black;
    Image img_white;
    Icon ico_white;
    Image img_black_queen;
    protected static  Icon ico_black_queen;
    Image img_white_queen;
    protected static Icon ico_white_queen;
    JFrame frame = new JFrame();
    JPanel tittle_panel = new JPanel();
    JPanel button_panel = new JPanel();
    static JLabel textfield = new JLabel();
    public static Field board[][] = new Field[8][8];
    static int  whitePoints=0;
    static int blackPoints=0;

    public Board() {
    }

    Board (Checkers checkers){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(80,80,5));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setText("Lets play checkers!!!");
        textfield.setOpaque(true);

        tittle_panel.setLayout(new BorderLayout());
        tittle_panel.setBounds(0,0,1000,100);

        button_panel.setLayout(new GridLayout(8,8));
        button_panel.setBackground(new Color(44,29,150));

        try {
            img_black_queen = ImageIO.read(getClass().getResource("black_figure_queen.png"));
            ico_black_queen = new ImageIcon(img_black_queen);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            img_white_queen = ImageIO.read(getClass().getResource("white_figure_queen.png"));
            ico_white_queen = new ImageIcon(img_white_queen);
        } catch (Exception ex) {
            System.out.println(ex);
        }

         creating_figures(checkers);

        tittle_panel.add(textfield);
        frame.add(tittle_panel,BorderLayout.NORTH);
        frame.add(button_panel);





    }
    public void creating_figures (Checkers checkers){
        for (int i = 0; i < 12; i++) {
           // Man man = new Man();

        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //board[i][j] = new JButton();
                board[i][j] = new Field();

                button_panel.add( board[i][j].button);

                //( board[i][j].button).setFocusable(false);
                (board[i][j].button).addMouseListener( checkers);
                //( board[i][j].button).setBackground(new Color(44,27,1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if ((i ) % 2 == 0) {
                for (int j = 0; j < 8; j += 2) {

                    board[i][j].button.setBackground(new Color(255,229,180));
                  //  Man man = new Man();

                }
            } else {
                for (int j = 1; j < 8; j += 2) {
                    board[i][j].button.setBackground(new Color(255,229,180));

                }
            }
        }

        try {
            img_white = ImageIO.read(getClass().getResource("white_figure.png"));
            ico_white = new ImageIcon(img_white);

            for (int i = 0; i < 3; i++) {
                if ((i ) % 2 == 0) {
                    for (int j = 0; j < 8; j += 2) {
                        board[i][j].button.setIcon(ico_white);
                        board[i][j].figures = new Man("White");

                        //board[i][j] = new Man();


                    }
                } else {
                    for (int j = 1; j < 8; j += 2) {
                        board[i][j].button.setIcon(ico_white);
                        board[i][j].figures = new Man("White");
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            img_black = ImageIO.read(getClass().getResource("black_figure.png"));
            ico_black = new ImageIcon(img_black);

            for (int i = 5; i < 8; i++) {
                if ((i ) % 2 == 0) {
                    for (int j = 0; j < 8; j += 2) {
                        board[i][j].button.setIcon(ico_black);
                        board[i][j].figures = new Man("Black");
                    }
                } else {
                    for (int j = 1; j < 8; j += 2) {
                        board[i][j].button.setIcon(ico_black);
                        board[i][j].figures = new Man("Black");

                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
//        try {
//            img_black_queen = ImageIO.read(getClass().getResource("black_figure_queen.png"));
//            ico_black_queen = new ImageIcon(img_black_queen);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        try {
//            img_white_queen = ImageIO.read(getClass().getResource("white_figure_queen.png"));
//            ico_white_queen = new ImageIcon(img_white_queen);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        board[2][0].button.setIcon(ico_white_queen);
//        board[2][0].figures = new King("White");
//        System.out.println(ico_white_queen);
    }



}
