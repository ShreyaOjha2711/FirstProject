import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.border.Border;
class TicTacToe implements ActionListener
{
    static int count=0;
    static String t="";
    static JLabel l=new JLabel();
    static int c[][]=new int[3][3];
    static JButton b[][]=new JButton[3][3];
    static char a[][]=new char[3][3];
    public String checkWin(char ar[][])
    {
        String r[]=new String[3];
        String c[]=new String[3];
        String d1="",d2="";
        for(int i=0;i<3;i++)
        {
            r[i]="";
            c[i]="";
            for(int j=0;j<3;j++)
            {
                r[i]+=ar[i][j];
                c[i]+=ar[j][i];
                if(i==j)
                {
                    d1+=ar[i][j];
                }
            }
        }
        d2=""+ar[0][2]+ar[1][1]+ar[2][0];
        for(int i=0;i<3;i++)
        {
            if(r[i].equals("XXX") || c[i].equals("XXX"))
            {
                return "P2";
            }
            else if(r[i].equals("OOO")||c[i].equals("OOO"))
            {
                return "P1";
            }
        }
        if(d1.contains("XXX") || d2.contains("XXX"))
        {
            return "P2";
        }
        else if(d1.contains("OOO")|| d2.contains("OOO"))
        {
            return "P1";
        }
        else
        {
            return "tie";
        }
    }

    public static void main(String args[])
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                b[i][j]=new JButton();
                b[i][j].setText("Click");
                b[i][j].setFocusable(false);
                b[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 24));
                b[i][j].setForeground(Color.WHITE);
                b[i][j].setBackground(new Color(9,8,74));
                b[i][j].setBounds(((100*j)+3),((100*i)+100),100,100);
                b[i][j].addActionListener(new TicTacToe());
            }     
        }

        Border bd=BorderFactory.createLineBorder(new Color(9,8,74),3);
        l.setText("<html>P1: O ; P2: X<br/>__P1 starts__</html>");
        l.setBounds(3,3,300,100);
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l.setBackground(Color.black);
        l.setForeground(Color.WHITE);
        l.setOpaque(true);
        l.setBorder(bd);

        ImageIcon img=new ImageIcon("C:\\Users\\91760\\OneDrive\\Desktop\\TTT.png");
        JFrame f=new JFrame();
        f.setSize(318,440);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setTitle("Tic Tac Toe");
        f.setVisible(true);
        f.add(l);
        f.setIconImage(img.getImage());
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                f.add(b[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(e.getSource()==b[i][j] && c[i][j]==0)
                {   
                    if(count%2!=0)
                    {
                        b[i][j].setText("X");
                        a[i][j]='X';
                        c[i][j]=1;
                    }
                    else if(count%2==0)
                    {
                        b[i][j].setText("O");
                        a[i][j]='O';
                        c[i][j]=1;
                    }
                    count++;
                }
                if(count>4)
                {
                    t=checkWin(a);
                    if(t.equalsIgnoreCase("P2"))
                    {
                        //System.out.println("P2");
                        for(int k=0;k<3;k++)
                        {
                            b[1][k].setText("P2");
                            b[0][k].setEnabled(false);
                            b[2][k].setEnabled(false);
                        }
                    }
                    else if(t.equalsIgnoreCase("P1"))
                    {
                        for(int k=0;k<3;k++)
                        {
                            b[1][k].setText("P1");
                            b[0][k].setEnabled(false);
                            b[2][k].setEnabled(false);
                        }
                    }
                }
            }
        }
        if(t.equalsIgnoreCase("tie") && count>8)
        {
            for(int k=0;k<3;k++)
            {
                b[1][k].setText("Tie");
                b[0][k].setEnabled(false);
                b[2][k].setEnabled(false);
            }
        }
    }
}
