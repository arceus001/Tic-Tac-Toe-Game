import java.util.*;
import javax.lang.model.util.ElementScanner14;
public class TicTacToe {
static int count=0;
    public static void printBoard(char board[][]){
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                System.out.print(board[row][col]);
                if(col!=2)
                    System.out.print("  |  ");
            }
            System.out.println("\n");
        }
    }

    public static boolean haveWon(char board[][],char player){
        count++;
        //checking for rows
        for(int row=0;row<3;row++){
          if(board[row][0]==player && board[row][1]==player && board[row][2]==player)  
            return true;
        }
        //checking for columns
        for(int col=0;col<3;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
                return true;
        }
        //checking for  leading diagonal
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        //checking for lagging diagonal
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
        return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char board[][]=new char[3][3];
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                switch(row+col){
                    case 0:board[0][0]='1';
                           break;
                    case 1:if(row==0)
                            board[0][1]='2';
                           else 
                            board[1][0]='4';
                           break;
                    case 2:if(row==0)
                            board[0][2]='3';
                           else if(col==0)
                            board[2][0]='7';
                           else 
                            board[1][1]='5';
                           break;
                    case 3:if(row==2)
                            board[2][1]='8';
                           else 
                            board[1][2]='6';
                           break;
                    case 4:board[2][2]='9';
                           break;
                    default:System.out.println("Invalid Input\n");
                }
            }
        }
        char player='X';
        boolean gameOver=false;
        while(!gameOver){
            printBoard(board);
            System.out.print("Player "+player+" enter:");
            int x=sc.nextInt();
            System.out.println();
            int row=-1,col=-1;
            switch(x){
                case 1:row=0;
                       col=0;
                       break;
                case 2:row=0;
                       col=1;
                       break;
                case 3:row=0;
                       col=2;
                       break;
                case 4:row=1;
                       col=0;
                       break;
                case 5:row=1;
                       col=1;
                       break;
                case 6:row=1;
                       col=2;
                       break;
                case 7:row=2;
                       col=0;
                       break;
                case 8:row=2;
                       col=1;
                       break;
                case 9: row=2;
                        col=2;
                        break;  
                default:System.out.println("\nInvalid move...Enter number between 1 to 9...!!!\n");   
            }
            if(x>0 && x<=9){
                if((board[row][col]!='0')&&(board[row][col]!='X')){
                    board[row][col]=player;
                    gameOver=haveWon(board,player);
                    if(gameOver){
                        System.out.println("\nHurray!!!\nPlayer "+player+" has WON\n");
                        printBoard(board);
                    }
                    else if((gameOver==false)&&(count==9)){
                        System.out.println("\nOops...It's a DRAW...!!!\n");
                        printBoard(board);
                        System.exit(0);
                    }
                    else {
                        player=(player=='X')?'0':'X';
                    }
                }
                else{
                    System.out.println("\nInvalid move...Try again...!!!\n");
                }
            }
        }
    }
}


