import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[][] board = {
                {" 1", " 2", " 3"},
                {" 4", " 5", " 6"},
                {" 7", " 8", " 9"}};

        boolean firstPlayer = true;
        boolean winner = false;
        int x = 0;

        while(true){

            //SHOWING THE BOARD

            for (String[] strings : board) {
                for (String string : strings) {
                    System.out.print(string);
                }
                System.out.println();
            }

            // I've inverted the "firsPlayer" cause when the for ends first player is reverse...
            if(winner || x == 9){
                if(winner && !firstPlayer){
                    System.out.println("O JOGADOR 1 GANHOUU!");
                }else if(winner){
                    System.out.println("O JOGADOR 2 GANHOUU!");
                }
                break;
            }

            // THE PLAY AND THE BOARD FILL

            System.out.println("\nDigite uma posição para marcar");
            String ans = " " + scan.next();

            boolean validMove = true;
            String currentPlayerSymbol = firstPlayer ? " X" : " 〇";

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(ans.equals(board[i][j])){
                        board[i][j] = currentPlayerSymbol;
                        firstPlayer = !firstPlayer;
                        validMove = true;
                        break;
                    }else{
                        validMove = false;
                    }
                }
                if (validMove){
                    break;
                }
            }

            if(!validMove){
                System.out.println("\nDigite novamente, porém certo!".toUpperCase());
                continue;
            }

            //THE READING THE BOARD AND DEFINITION OF THE WINNER

            for (int i = 0; i < 3; i++) {
                if(board[i][0].equals(currentPlayerSymbol)
                        && board[i][1].equals(currentPlayerSymbol)
                        && board[i][2].equals(currentPlayerSymbol)){
                    winner = true;
                } else if(board[0][i].equals(currentPlayerSymbol)
                        && board[1][i].equals(currentPlayerSymbol)
                        && board[2][i].equals(currentPlayerSymbol)){
                    winner = true;
                }
            }

            if(board[0][0].equals(currentPlayerSymbol)
                    && board[1][1].equals(currentPlayerSymbol)
                    && board[2][2].equals(currentPlayerSymbol)){
                winner = true;
            } else if(board[0][2].equals(currentPlayerSymbol)
                    && board[1][1].equals(currentPlayerSymbol)
                    && board[2][0].equals(currentPlayerSymbol)){
                winner = true;
            }

            x++;
        }

    }
}
