import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {

    static JFrame frame;
    static ImageIcon image;
    static JButton [] buttons = new JButton[25];
    static JButton Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,btn9,btn10,
            btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,
            btn21,btn22,btn23,btn24,btn25;
    static JPanel panel;
    static boolean playerXTurn = true;
    static boolean gameActive = true;
    public static void main(String[] args) {

        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(460,120,550,550);
        frame.setLayout(null);
        frame.setResizable(false);

        image = new ImageIcon("TTT.png");
        frame.setIconImage(image.getImage());

        Font myfont = new Font("my font",Font.BOLD,30);

        Btn1 = new JButton("");
        Btn2 = new JButton("");
        Btn3 = new JButton("");
        Btn4 = new JButton("");
        Btn5 = new JButton("");
        Btn6 = new JButton("");
        Btn7 = new JButton("");
        Btn8 = new JButton("");
        btn9 = new JButton("");
        btn10 = new JButton("");
        btn11 = new JButton("");
        btn12 = new JButton("");
        btn13 = new JButton("");
        btn14 = new JButton("");
        btn15 = new JButton("");
        btn16 = new JButton("");
        btn17 = new JButton("");
        btn18 = new JButton("");
        btn19 = new JButton("");
        btn20 = new JButton("");
        btn21 = new JButton("");
        btn22 = new JButton("");
        btn23 = new JButton("");
        btn24 = new JButton("");
        btn25 = new JButton("");

        buttons [0] = Btn1;
        buttons [1] = Btn2;
        buttons [2] = Btn3;
        buttons [3] = Btn4;
        buttons [4] = Btn5;
        buttons [5] = Btn6;
        buttons [6] = Btn7;
        buttons [7] = Btn8;
        buttons [8] = btn9;
        buttons [9] = btn10;
        buttons [10] = btn11;
        buttons [11] = btn12;
        buttons [12] = btn13;
        buttons [13] = btn14;
        buttons [14] = btn15;
        buttons [15] = btn16;
        buttons [16] = btn17;
        buttons [17] = btn18;
        buttons [18] = btn19;
        buttons [19] = btn20;
        buttons [20] = btn21;
        buttons [21] = btn22;
        buttons [22] = btn23;
        buttons [23] = btn24;
        buttons [24] = btn25;

        for(int i=0; i<25 ; i++){
            buttons[i].setFocusable(false);
            buttons[i].setFont(myfont);
            buttons[i].setBackground(Color.pink);
            buttons[i].setForeground(Color.BLACK);
            buttons[i].addActionListener(new ButtonClickListener());
        }


        panel = new JPanel();
        panel.setBounds(0,0,536,513);
        panel.setBackground(Color.white);
        panel.setLayout(new GridLayout(5,5,5,5));
       for(int j=0 ; j<25 ; j++){
           panel.add(buttons[j]);
       }
        frame.add(panel);
        frame.setVisible(true);
    }

    private static void checkForWin() {
        // Check rows
        for (int i = 0; i < 25; i += 5) {
            if (buttons[i].getText().equals(buttons[i + 1].getText()) &&
                    buttons[i].getText().equals(buttons[i + 2].getText()) &&
                    buttons[i].getText().equals(buttons[i + 3].getText()) &&
                    buttons[i].getText().equals(buttons[i + 4].getText()) &&
                    !buttons[i].getText().equals("")) {
                announceWinner(buttons[i].getText());
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 5; i++) {
            if (buttons[i].getText().equals(buttons[i + 5].getText()) &&
                    buttons[i].getText().equals(buttons[i + 10].getText()) &&
                    buttons[i].getText().equals(buttons[i + 15].getText()) &&
                    buttons[i].getText().equals(buttons[i + 20].getText()) &&
                    !buttons[i].getText().equals("")) {
                announceWinner(buttons[i].getText());
                return;
            }
        }

        // Check diagonals
        if (buttons[0].getText().equals(buttons[6].getText()) &&
                buttons[0].getText().equals(buttons[12].getText()) &&
                buttons[0].getText().equals(buttons[18].getText()) &&
                buttons[0].getText().equals(buttons[24].getText()) &&
                !buttons[0].getText().equals("")) {
            announceWinner(buttons[0].getText());
            return;
        }

        if (buttons[4].getText().equals(buttons[8].getText()) &&
                buttons[4].getText().equals(buttons[12].getText()) &&
                buttons[4].getText().equals(buttons[16].getText()) &&
                buttons[4].getText().equals(buttons[20].getText()) &&
                !buttons[4].getText().equals("")) {
            announceWinner(buttons[4].getText());
            return;
        }


        boolean draw = true;
        for (int i = 0; i < 25; i++) {
            if (buttons[i].getText().equals("")) {
                draw = false;
                break;
            }
        }

        if (draw) {
            JOptionPane.showMessageDialog(frame, "It's a draw!");
            gameActive = false;
            askToPlayAgain();
        }
    }

    private static void announceWinner(String winner) {
        JOptionPane.showMessageDialog(frame, winner + " wins!");
        gameActive = false;
        askToPlayAgain();
    }


    private static void askToPlayAgain() {
        int response = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            frame.dispose();
        }
    }


    private static void resetGame() {
        for (int i = 0; i < 25; i++) {
            buttons[i].setText("");
            buttons[i].setForeground(Color.BLACK);
        }
        playerXTurn = true;
        gameActive = true;
    }


    static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if (!gameActive || !clickedButton.getText().equals("")) {
                return;
            }

            if (playerXTurn) {
                clickedButton.setText("X");
                clickedButton.setForeground(Color.RED);
            } else {
                clickedButton.setText("O");
                clickedButton.setForeground(Color.BLUE);
            }

            playerXTurn = !playerXTurn;

            checkForWin();
        }
    }
}


