package gomoku.strategies;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
/**
 *
 * @author CHRIST
 */
public class Minimax2 {
    final static int N=1;//depth of the tree.
    final static int SIZE=10;
    int[][] board=new int[SIZE][SIZE];
   public Minimax2(){
    int i;
    for(i=0;i<SIZE;i++)
    {
        Arrays.fill(board[i], 0);
    }
}
   //a player move his piece.
    public void movea(int i, int j){
        board[i][j]=-1;
    }
    //b player move his piece.
    public void moveb(int i,int j)
    {
        board[i][j]=1;
    }
    //check how many consecutive square are there in the board.  and how lone are they seperately.
    public int[] consecutivecheck(char player,int[] ends)
    {
        int[] consecutive=new int[300];
        Arrays.fill(consecutive, 0);
        int i,j,m;
        int num;
        int pos=0;
        //player a
        if(player=='a')
        {
                      
            //first, horizontally .
        for(i=0;i<SIZE;i++)
        {
            num=1;
            for(j=0;j<SIZE-1;j++)
            {
                if(board[i][j]==-1&&board[i][j+1]==-1)
                    ++num;
                else if(num!=1)
                {consecutive[pos]=num;
                if(j-num==-1)
                    ends[pos]++;
                else if(board[i][j-num]==1)
                    ends[pos]++;
                 if(board[i][j+1]==1)
                    ends[pos]++;
                pos++;
                num=1;   
                }
                if(j==SIZE-2)
                if(num!=1)
                {consecutive[pos]=num;
                if(board[i][j-num+1]==1)
                    ends[pos]++;
                if(board[i][j+1]!=0)
                ends[pos]++;
                pos++;
                }
            }
        }
        // vertically.
        for(j=0;j<SIZE;j++)
        {  
            num=1;
            for(i=0;i<SIZE-1;i++)
            {
                if(board[i][j]==-1&&board[i+1][j]==-1)
                {
                    num++;
                }
                else if(num!=1)
                {
                    consecutive[pos]=num;
                    if(i-num==-1)
                        ends[pos]++;
                    else if(board[i-num][j]==1)
                        ends[pos]++;
                    if(board[i+1][j]==1)
                        ends[pos]++;
                    pos++;
                    num=1;
                }
                if(i==SIZE-2)
                  if(num!=1)
                {
                    consecutive[pos]=num;
                    if(board[i-num+1][j]==1)
                        ends[pos]++;
                    if(board[i+1][j]!=0)
                    ends[pos]++;
                    pos++;
                }  
            }
        }
        //left incline.
        for(j=1;j<SIZE;j++)
        {
            i=0;num=1;m=j;
            for(;m>0;m--,i++)
            {
            if(board[i][m]==-1&&board[i+1][m-1]==-1)
                num++;
            else if(num!=1)
            {
                consecutive[pos]=num;
                if(i-num==-1)
                    ends[pos]++;
                else if(board[i-num][m+num]==1)
                    ends[pos]++;
                if(board[i+1][m-1]==1)
                    ends[pos]++;
                    pos++;
                    num=1;
            }
            if(m==1)
                if(num!=1)
            {
                consecutive[pos]=num;
                 if(i-num==-2)
                    ends[pos]++;
                else if(board[i-num+1][m+num-1]==1)
                    ends[pos]++;
                if(board[i+1][m-1]!=0)
                    ends[pos]++;
                    pos++;
            }
            }
        }
        for(i=1;i<SIZE-1;i++)
        {
            j=SIZE-1;num=1;m=i;
            for(;j<SIZE-1;m++,j--)
            {
                if(board[m][j]==-1&&board[m+1][j-1]==-1)
                    num++;
                else if(num!=1)
            {
                consecutive[pos]=num;
                if(j+num==SIZE)
                    ends[pos]++;
                else if(board[m-num][j+num]==1)
                    ends[pos]++;
                if(board[m+1][j-1]==1)
                    ends[pos]++;
                    pos++;
                    num=1;
            }
            if(m==SIZE-2)
                if(num!=1)
            {
                consecutive[pos]=num;
                 if(j+num==SIZE+1)
                    ends[pos]++;
                else if(board[m-num+1][j+num-1]==1)
                    ends[pos]++;
                if(board[m+1][j-1]!=0)
                    pos++;
            }
            }
        }
        //right incline.
       for(j=0;j<SIZE-1;j++)
        {
            i=0;num=1;m=j;
            for(;m<SIZE-1;m++,i++)
                if(board[i][m]==-1&&board[i+1][m+1]==-1)
                    num++;
                else  if(num!=1)
            {
                consecutive[pos]=num;
                if(i-num==-1)
                    ends[pos]++;
                else if(board[i-num][m-num]==1)
                    ends[pos]++;
                if(board[i+1][m+1]==1)
                    ends[pos]++;
                    pos++;
                    num=1;
            }
            if(m==SIZE-2)
                if(num!=1)
            {
                consecutive[pos]=num;
                 if(i-num==-2)
                    ends[pos]++;
                else if(board[i-num+1][m-num+1]==1)
                    ends[pos]++;
                if(board[i+1][m+1]!=0)
                    ends[pos]++;
                    pos++;
            }
        }
        for(i=1;i<SIZE-1;i++)
        {
            j=0;num=1;m=i;
            for(;m<SIZE-1;m++,j++)
                if(board[m][j]==-1&&board[m+1][j+1]==-1)
                num++;
                else if (num!=1)
                {
                    consecutive[pos]=num;
                    if(j-num==-1)
                        ends[pos]++;
                    else if(board[m-num][j-num]==1)
                        ends[pos]++;
                    if(board[m+1][j+1]==1)
                        ends[pos]++;
                    pos++;
                    num=1;
                }
            if(m==SIZE-2)
                 if (num!=1)
                {
                    consecutive[pos]=num;
                    if(j-num==-2)
                        ends[pos]++;
                    else if(board[m-num+1][j-num+1]==1)
                        ends[pos]++;
                    if(board[m+1][j+1]!=0)
                        ends[pos]++;
                    pos++;
                }
        }
        }
        //player b.
      if(player=='b')
        {
           
            //first, horizontally .
        for(i=0;i<SIZE;i++)
        {
            num=1;
            for(j=0;j<SIZE-1;j++)
            {
                if(board[i][j]==1&&board[i][j+1]==1)
                    ++num;
                else if(num!=1)
                {consecutive[pos]=num;
                if(j-num==-1)
                    ends[pos]++;
                else if(board[i][j-num]==-1)
                    ends[pos]++;
                 if(board[i][j+1]==-1)
                    ends[pos]++;
                pos++;
                num=1;   
                }
                if(j==SIZE-2)
                if(num!=1)
                {consecutive[pos]=num;
                if(board[i][j-num]==-1)
                    ends[pos]++;
                if(board[i][j+1]!=0)
                ends[pos]++;
                pos++;
                }
            }
        }
        // vertically.
        for(j=0;j<SIZE;j++)
        {  
            num=1;
            for(i=0;i<SIZE-1;i++)
            {
                if(board[i][j]==1&&board[i+1][j]==1)
                {
                    num++;
                }
                else if(num!=1)
                {
                    consecutive[pos]=num;
                    if(i-num==-1)
                        ends[pos]++;
                    else if(board[i-num][j]==-1)
                        ends[pos]++;
                    if(board[i+1][j]==-1)
                        ends[pos]++;
                    pos++;
                    num=1;
                }
                if(i==SIZE-2)//some problems here.
                  if(num!=1)
                {
                    consecutive[pos]=num;
                    if(board[i-num][j]==-1)
                        ends[pos]++;
                    if(board[i+1][j]!=0)
                    ends[pos]++;
                    pos++;
                }  
            }
        }
        //left incline.
        for(j=1;j<SIZE;j++)
        {
            i=0;num=1;m=j;
            for(;m>0;m--,i++)
            {
            if(board[i][m]==1&&board[i+1][m-1]==1)
                num++;
            else if(num!=1)
            {
                consecutive[pos]=num;
                if(i-num==-1)
                    ends[pos]++;
                else if(board[i-num][m+num]==-1)
                    ends[pos]++;
                if(board[i+1][m-1]==-1)
                    ends[pos]++;
                    pos++;
                    num=1;
            }
            if(m==1)
                if(num!=1)
            {
                consecutive[pos]=num;
                 if(i-num==-2)
                    ends[pos]++;
                else if(board[i-num+1][m+num-1]==-1)
                    ends[pos]++;
                if(board[i+1][m-1]!=0)
                    ends[pos]++;
                    pos++;
            }
            }
        }
        for(i=1;i<SIZE-1;i++)
        {
            j=SIZE-1;num=1;m=i;
            for(;j<SIZE-1;m++,j--)
            {
                if(board[m][j]==1&&board[m+1][j-1]==1)
                    num++;
                else if(num!=1)
            {
                consecutive[pos]=num;
                if(j+num==SIZE)
                    ends[pos]++;
                else if(board[m-num][j+num]==-1)
                    ends[pos]++;
                if(board[m+1][j-1]==-1)
                    ends[pos]++;
                    pos++;
                    num=1;
            }
            if(m==SIZE-2)
                if(num!=1)
            {
                consecutive[pos]=num;
                 if(j+num==SIZE+1)
                    ends[pos]++;
                else if(board[m-num+1][j+num-1]==-1)
                    ends[pos]++;
                if(board[m+1][j-1]!=0)
                    pos++;
            }
            }
        }
        //right incline.
       for(j=0;j<SIZE-1;j++)
        {
            i=0;num=1;m=j;
            for(;m<SIZE-1;m++,i++)
                if(board[i][m]==1&&board[i+1][m+1]==1)
                    num++;
                else  if(num!=1)
            {
                consecutive[pos]=num;
                if(i-num==-1)
                    ends[pos]++;
                else if(board[i-num][m-num]==-1)
                    ends[pos]++;
                if(board[i+1][m+1]==-1)
                    ends[pos]++;
                    pos++;
                    num=1;
            }
            if(m==SIZE-2)
                if(num!=1)
            {
                consecutive[pos]=num;
                 if(i-num==-2)
                    ends[pos]++;
                else if(board[i-num+1][m-num+1]==-1)
                    ends[pos]++;
                if(board[i+1][m+1]!=0)
                    ends[pos]++;
                    pos++;
            }
        }
        for(i=1;i<SIZE-1;i++)
        {
            j=0;num=1;m=i;
            for(;m<SIZE-1;m++,j++)
                if(board[m][j]==1&&board[m+1][j+1]==1)
                num++;
                else if (num!=1)
                {
                    consecutive[pos]=num;
                    if(j-num==-1)
                        ends[pos]++;
                    else if(board[m-num][j-num]==-1)
                        ends[pos]++;
                    if(board[m+1][j+1]==-1)
                        ends[pos]++;
                    pos++;
                    num=1;
                }
            if(m==SIZE-2)
                 if (num!=1)
                {
                    consecutive[pos]=num;
                    if(j-num==-2)
                        ends[pos]++;
                    else if(board[m-num+1][j-num+1]==-1)
                        ends[pos]++;
                    if(board[m+1][j+1]!=0)
                        ends[pos]++;
                    pos++;
                }
        }
        }
        return consecutive;
    }
    public int score(int consecutive[],int[] ends,boolean currentturn){
        int i;
        int sum=0;
        for(i=0;i<300;i++)
        {
             if(consecutive[i]==5)
                sum+=200000;
             else
           if(ends[i]==2)
            {   sum+=0;}
            else
            switch(consecutive[i])
            {
                case 4: switch(ends[i])
                { case 0: if(currentturn) sum+=20000;
                    else sum+=10000;
                    case 1:if(currentturn) sum+=10000;
                    else sum+=5000;
                }
                case 3: switch(ends[i])
                {
                    case 0:if(currentturn) sum+=2000;
                    else sum+=20;
                    case 1:if(currentturn) sum+=10;
                    else sum+=5;
                }
                case 2: switch(ends[i])
                {
                    case 0:if(currentturn) sum+=5;
                    else sum+=2;
                    case 1:if(currentturn) sum+=3;
                }
            }
        }
        return sum;
    }
   
    public void elimimovea(int i,int j)
    {
        board[i][j]=0;
    }
    public void elimimoveb(int i,int j)
    {
        board[i][j]=0;
    }
     public int alphabeta(int m,int n,int depth,char player,int alpha, int beta){
        int bestvalue;
        int i,j;
        int label;
        int[] consecutive1 =new int[300];
        int[] consecutive2 =new int[300];
        int[] ends1=new int[300];
        int[] ends2=new int[300];
        Arrays.fill(consecutive1, 0);
        Arrays.fill(consecutive2, 0);
        Arrays.fill(ends1, 0);
        Arrays.fill(ends2, 0);
        if(player=='a')   
        { 
            bestvalue=Integer.MIN_VALUE;
            if(depth==0)
        { movea(m,n);
        consecutive1=consecutivecheck('a',ends1);
        consecutive2=consecutivecheck('b',ends2);
        label=score(consecutive1,ends1,false)-score(consecutive2,ends2,true);
        elimimovea(m,n);
        return label;
        }
        else {
                movea(m,n);
                loop:       for(i=0;i<SIZE;i++)
            for(j=0;j<SIZE;j++)
            {
                if(board[i][j]==0)
                { 
                   label=alphabeta(i,j,depth-1,'b',alpha,beta);
                    if(bestvalue<label)
                    { 
                        bestvalue=label;
                    }
                    alpha=Integer.max(alpha, bestvalue);
                    if(beta<=alpha)
                    {
                        break loop;
                    }
                }
            }
            elimimovea(m,n);
            return bestvalue;
                }
        }
        if(player=='b')
        {
            bestvalue=Integer.MAX_VALUE;
            if(depth==0)
        { moveb(m,n);
        consecutive1=consecutivecheck('a',ends1);
        consecutive2=consecutivecheck('b',ends2);
        label=score(consecutive1,ends1,true)-score(consecutive2,ends2,false);
        elimimoveb(m,n);
        return label;
        }
        else {
                moveb(m,n);
                loop:      for(i=0;i<SIZE;i++)
            for(j=0;j<SIZE;j++)
            {
                if(board[i][j]==0)
                {  
                    label=alphabeta(i,j,depth-1,'a',alpha,beta);
                    if(bestvalue>label)
                    { 
                        bestvalue=label;
                    }
                    beta=Integer.min(beta, bestvalue);
                    if(beta<=alpha)
                    {
                        break loop;
                    }
                }
            }
            elimimoveb(m,n);
            return bestvalue;
                }
        }
        return 0;
    }
    //used to decide the best next move of b. if it is b's turn.the position is recorded in a array of size 2.
    public int[] getnextb()
    {
        int bestvalue,i,j;
         int alpha=Integer.MIN_VALUE;
        int beta=Integer.MAX_VALUE;
        int[] position=new int[2];
        bestvalue=Integer.MAX_VALUE;
        for(i=0;i<SIZE;i++)
        {   for(j=0;j<SIZE;j++)
            {  if(board[i][j]==0)
            {
             if(alphabeta(i,j,N,'b',alpha,beta)<bestvalue)
            {
                bestvalue=alphabeta(i, j, N, 'b',alpha,beta);
                position[0]=i;
                position[1]=j;
            }
            }
            }
        }
        return position;
    }
    //used to decide the best next move of a, if it is a's turn.the position is recorded in a array of size 2.
    public int[] getnexta()
    {
        int bestvalue,i,j;
        int alpha=Integer.MIN_VALUE;
        int beta=Integer.MAX_VALUE;
        int[]  position=new int[2];
        bestvalue=Integer.MIN_VALUE;
        for(i=0;i<SIZE;i++)
        {   for(j=0;j<SIZE;j++)
            {  if(board[i][j]==0)
            {
             if(alphabeta(i,j,N,'a',alpha,beta)>bestvalue)
            {
                bestvalue=alphabeta(i, j, N, 'a',alpha,beta);
                position[0]=i;
                position[1]=j;
            }
            }
            }
        }
        return position;
    }
}
