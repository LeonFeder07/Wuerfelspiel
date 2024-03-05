package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spiel {
    private JButton wüerfelnButton;
    private JTextField wuerfelausgabe;
    private JPanel panel;
    private JButton wuerfelErstellenButton;
    private JTextField seiteneingabe;
    private JButton addiereXButton;
    private JTextField eingabefeld;
    private JTextField ausgabefeldTextField;
    private JButton maxFindenButton;
    private JButton gibXErgebnisseButton;
    private JTextArea textArea1;
    Wuerfel wuerfel;

    public Spiel() {
    wüerfelnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(wuerfel != null){
            wuerfelausgabe.setText(String.valueOf(wuerfel.wuerfeln()));
        }}
    });
        wuerfelErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
if(seiteneingabe.getText()!= null && seiteneingabe.getText()!="") {
    wuerfel = new Wuerfel(Integer.valueOf(seiteneingabe.getText()));
    seiteneingabe.setText("");
}

            }
        });
        addiereXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textArea1.setText("");
                ausgabefeldTextField.setText(String.valueOf(addiereX(Integer.valueOf(eingabefeld.getText()))));
                eingabefeld.setText("");
            }
        });

        maxFindenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textArea1.setText("");
                ausgabefeldTextField.setText(String.valueOf(maxFinden(Integer.valueOf(eingabefeld.getText()))));
                eingabefeld.setText("");
            }
        });
        gibXErgebnisseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                ausgabefeldTextField.setText(String.valueOf(gibXergebnisse(Integer.valueOf(eingabefeld.getText()))));
                eingabefeld.setText("");
            }
        });
    }
    public int addiereX(int x){
        if(x==0){
            return 0;
        }
        int zahl=(wuerfel.wuerfeln());
        String zahlS=String.valueOf(zahl);
        textArea1.setText(textArea1.getText()+zahlS+"\n" );
        return zahl+this.addiereX(x-1);
    }
    public int maxFinden( int x){
        if(x==0){
            return 0;
        }else{
            int zahl=(wuerfel.wuerfeln());
            String zahlS=String.valueOf(zahl);
            textArea1.setText(textArea1.getText()+zahlS+"\n" );
            return  Math.max(zahl,this.maxFinden(x-1));
        }
    }
    public int gibXergebnisse(int x){
        if(x==0){
            return 0;
        }else{
            int zahl=(wuerfel.wuerfeln());
            String zahlS=String.valueOf(zahl);
            textArea1.setText(textArea1.getText()+zahlS+"\n" );
            return (int) (Math.pow(10,(x-1))*zahl+gibXergebnisse(x-1));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Spiel");
        frame.setContentPane(new Spiel().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
