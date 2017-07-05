package GUI;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ServerAddress extends JFrame  {
    private JButton btn;
    private JTextField serverAddress;
    private JButton submitAddress;
    protected javax.swing.JPanel JPanel;
    private JLabel label;

    public ServerAddress(){
        super("Server Address");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setFont(new Font("Serif",Font.BOLD,22));
        submitAddress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(serverAddress.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Please fill all the fields");
                }
                else {
                    if (checkServerAddress(serverAddress.getText())) {
                        JFrame jFrame = new JFrame("Address Validation");
                        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        jFrame.setContentPane(new AddressValidate(serverAddress.getText()).JPanel);
                        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        jFrame.pack();
                        jFrame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"The server address you entered cannot be reached");
                    }
                }
            }
        });
    }
    public static void main(String[] args){
        ServerAddress index=new ServerAddress();
        index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        index.pack();
        index.setVisible(true);

    }
    private boolean checkServerAddress(String address){
        try {
            URL url=new URL(address);
            URLConnection myURLConnection = url.openConnection();
            myURLConnection.connect();
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}

