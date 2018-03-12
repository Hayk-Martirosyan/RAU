package com.game.mainclasses;

/**
 * This class represents a standard board for "Tic tac toe" game
 * @see com.game.mainclasses.TicTacToe
 * the size of the board can vary
 */
public class Board {

    /**
     * content of empty board cell
     */
    public static final int  EMPTY=0;
    /**
     * content of board cell containing X
     */
        public static final int  X=1;
    /**
     * content of board cell containing O
     */
        public static final int  O=2;

    /**
     * as soon as game ends and it is draw status is set DRAW
     */
    public static final int  DRAW=0;
    /**
     * as soon as game ends and it X  wins status is set XWINNER
     */
    public static final int  XWINNER=1;
    /**
     * as soon as game ends and it O  wins status is set OWINNER
     */
    public static final int  OWINNER=2;
    /**
     * while the game is not over status is GOINGON
     */
    public static final int  GOINGON=3;



        private int[][] MyBoard;
        private int turn;
        private int status;


        private void switchTurn(){
            turn=3-turn;
        }

        private boolean isLegalMove(int rowInd, int columnInd){
            return status==GOINGON && MyBoard[rowInd][columnInd]==GOINGON;
        }

        private void RefreshStatus(){

        }

    /**
     *
     * @param rows how many rows Board must have
     * @param columns how many columns Board must have
     */
    public Board(int rows, int columns){
            MyBoard=new int[rows][columns];

            turn=X;
            status=GOINGON;
        }

    /**
     * puts X or O in the mentioned cell depending whose turn is
     * @param rowInd in which row the cell is
     * @param columnInd in which column the cell is
     * @return returns false if the move was illegal
     */
        public boolean  makeMove(int rowInd, int columnInd){
            if(isLegalMove(rowInd,columnInd)){
                MyBoard[rowInd][columnInd]= ( (turn==X) ? X : O );

                switchTurn();
                RefreshStatus();

                return true;
            }
            else{
                return false;
            }
        }

    /**
     *  demonstrates the Board
     */
    public void show(){

        };

    /**
     * @return one of the values DRAW, XWINNER , OWINNER, GOINGON
     */
        int getStatus(){
            return status;
        }

    /**
     *
     * @return one of the values X or O
     */
    int getTurn(){
            return turn;
        }

    /**
     *
     * @param rowInd in which row
     * @param columnInd in which column
     * @return content of the cell
     */
        int getBoardCellContent(int rowInd, int columnInd){
            return MyBoard[rowInd][columnInd];
    };
}


