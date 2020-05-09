package com.fahim.tictactoe;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int currentPlayer = 1;
    public int[][] BOARD = new int[3][3];
    public TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        status = findViewById(R.id.status);
        status.setText("Player 1 Turn");

        for (int i=0;i<3;i++)
            for(int j=0;j<3;j++) BOARD[i][j] = 0;
    }

    public void buttonA(View view){
        handleAction(0,0,view);
    }
    public void buttonB(View view){
        handleAction(0,1,view);
    }
    public void buttonC(View view){
        handleAction(0,2,view);
    }
    public void buttonD(View view){
        handleAction(1,0,view);
    }
    public void buttonE(View view){
        handleAction(1,1,view);
    }
    public void buttonF(View view){
        handleAction(1,2,view);
    }
    public void buttonG(View view){
        handleAction(2,0,view);
    }
    public void buttonH(View view){
        handleAction(2,1,view);
    }
    public void buttonI(View view){
        handleAction(2,2,view);
    }

    public void handleAction(int i,int j,View view){
        if(BOARD[i][j]>0) return;

        BOARD[i][j] = currentPlayer;
        if(currentPlayer == 1) {
            view.setBackgroundResource(R.drawable.one);
            currentPlayer = 2;
            status.setText("Player 2 Turn");
        }
        else  {
            view.setBackgroundResource(R.drawable.two);
            currentPlayer = 1;
            status.setText("Player 1 Turn");
        }

        gameResult();
    }

    public void gameResult(){

        int cnt =0 ;
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(BOARD[i][j]==0) cnt++;
            }
        }
        if(cnt==0) status.setText("Match Draw");
        boolean matchEnded = true;

        if(BOARD[0][0]==1 && BOARD[0][1]==1 && BOARD[0][2]==1) status.setText("Player 1 Won");
        else if(BOARD[1][0]==1 && BOARD[1][1]==1 && BOARD[1][2]==1) status.setText("Player 1 Won");
        else if(BOARD[2][0]==1 && BOARD[2][1]==1 && BOARD[2][2]==1) status.setText("Player 1 Won");
        else if(BOARD[0][0]==1 && BOARD[1][0]==1 && BOARD[2][0]==1) status.setText("Player 1 Won");
        else if(BOARD[0][1]==1 && BOARD[1][1]==1 && BOARD[2][1]==1) status.setText("Player 1 Won");
        else if(BOARD[0][2]==1 && BOARD[1][2]==1 && BOARD[2][2]==1) status.setText("Player 1 Won");
        else if(BOARD[0][0]==1 && BOARD[1][1]==1 && BOARD[2][2]==1) status.setText("Player 1 Won");
        else if(BOARD[0][2]==1 && BOARD[1][1]==1 && BOARD[2][0]==1) status.setText("Player 1 Won");

        else if(BOARD[0][0]==2 && BOARD[0][1]==2 && BOARD[0][2]==2) status.setText("Player 1 Won");
        else if(BOARD[1][0]==2 && BOARD[1][1]==2 && BOARD[1][2]==2) status.setText("Player 1 Won");
        else if(BOARD[2][0]==2 && BOARD[2][1]==2 && BOARD[2][2]==2) status.setText("Player 1 Won");
        else if(BOARD[0][0]==2 && BOARD[1][0]==2 && BOARD[2][0]==2) status.setText("Player 1 Won");
        else if(BOARD[0][1]==2 && BOARD[1][1]==2 && BOARD[2][1]==2) status.setText("Player 1 Won");
        else if(BOARD[0][2]==2 && BOARD[1][2]==2 && BOARD[2][2]==2) status.setText("Player 1 Won");
        else if(BOARD[0][0]==2 && BOARD[1][1]==2 && BOARD[2][2]==2) status.setText("Player 1 Won");
        else if(BOARD[0][2]==2 && BOARD[1][1]==2 && BOARD[2][0]==2) status.setText("Player 1 Won");

        else matchEnded = false;

        if(matchEnded){
            for (int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    BOARD[i][j] = 3;
                }
            }
        }
    }

    public void resetGame(View view){
        this.recreate();
    }

}
