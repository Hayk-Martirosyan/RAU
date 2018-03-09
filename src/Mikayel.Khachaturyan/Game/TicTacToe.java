package Game;
/*

Tic-Tac-Toe Game


 */


import java.io.File;

public class TicTacToe {
    public enum m { a, b, c};
    public static void main(String[] args) {


    }
}

class Board {
   public static final int  Empty=0;
   public static final int  X=1;
   public static final int  O=2;


   public static final int  Draw=0;
   public static final int  XWinner=1;
   public static final int  OWinner=2;
   public static final int  GoingOn=3;



   private int[][] MyBoard;
   private int turn;
   private int status;

   private void SwitchTurn(){
       turn=3-turn;
   }

   private boolean IsLegalMove(int rowInd, int columnInd){
       return status==GoingOn && MyBoard[rowInd][columnInd]==Empty;
   }

   private void RefreshStatus(){

   }

    public Board(int rows, int columns){
        MyBoard=new int[rows][columns];

        turn=X;
        status=GoingOn;
    }
    public boolean  MakeMove(int rowInd, int columnInd){
       if(IsLegalMove(rowInd,columnInd)){
           MyBoard[rowInd][columnInd]= ( (turn==X) ? X : O );

           SwitchTurn();
           RefreshStatus();

           return true;
       }
       else{
           return false;
       }
    }
    public void Show(){

    };


    int getStatus(){
        return status;
    }
    int getTurn(){
        return turn;
    }
}
class ScoreKeeper{
    //TODO
    private String PlayerName1;
    private String PlayerName2;

    private int Score1;
    private int Score2;

    ScoreKeeper(String Name1, String Name2){
        PlayerName1=Name1;
        PlayerName2=Name2;

        Score1=0;
        Score2=0;
    }
    public void AddScore1(){
        Score1++;
    }
    public void AddScore2(){
        Score2++;
    }
    public int getScore1(){
        return Score1;
    }
    public int getScore2(){
        return Score2;
    }
    public void show(){

    }


}
class Player{

    private String PlayerName;
    private int[]  ScoreHistory;
    private int    HighScore;

    Player(String Name){
        PlayerName=Name;
        ScoreHistory=new int[100];
        HighScore=0;
    }
    void AddScore(){

    }

    String getPlayerName(){
        return PlayerName;
    }
    int getHighScore(){
        return HighScore;
    }
    int [] getScoreHistory(){
        return ScoreHistory;
    }

}
class Game{

    private ScoreKeeper scoreKeeper;
    private Board       board;
    private String      GameRules;
    private Player  player;

    Game(){

    }
    void OpenGame(){

    }
    void RegisterPlayer(){

    }
    void RemovePlayer(){

    }
    void StartNewRound(){

    }
    void FinishTheRound(){

    }
    void CloseGame(){

    };

}



