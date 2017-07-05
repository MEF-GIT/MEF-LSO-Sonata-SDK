package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class BillingInfo {
    public javax.swing.JPanel JPanel;
    private String responseId;
    private JTextField email;
    private JTextField latitude;
    private JTextField telephone;
    private JTextField longitude;
    private JTextField contactName;
    private JButton submitButton;
    private JComboBox pricingMethod;
    private JLabel fillLabel;
    private JLabel contactLabel;
    private JLabel addresLabel;
    private JLabel emailLabel;
    private JLabel teleLabel;
    private JLabel contactNameLabel;
    private JLabel latLabel;
    private JLabel langLabel;
    private JLabel priceLabel;
    private String serverAddress;

    public BillingInfo(final String responseId, String serverAddress) {
        this.responseId=responseId;
        this.serverAddress=serverAddress;
        fillLabel.setFont(new Font("Serif", Font.BOLD,26));
        contactLabel.setFont(new Font("Serif", Font.BOLD,20));
        addresLabel.setFont(new Font("Serif", Font.BOLD,20));
        emailLabel.setFont(new Font("Serif", Font.BOLD,16));
        teleLabel.setFont(new Font("Serif", Font.BOLD,16));
        contactNameLabel.setFont(new Font("Serif", Font.BOLD,16));
        latLabel.setFont(new Font("Serif", Font.BOLD,16));
        langLabel.setFont(new Font("Serif", Font.BOLD,16));
        priceLabel.setFont(new Font("Serif", Font.BOLD,16));
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(email.getText().length()==0||telephone.getText().length()==0||contactName.getText().length()==0||
                        latitude.getText().length()==0||longitude.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Please fill all the fields");
                }
                else{
                    try {
                        String orderId=submitNewOrder(responseId,email.getText(),telephone.getText(),contactName.getText(),
                                latitude.getText(),longitude.getText(),pricingMethod.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(null,"Your Order was successfully received.\n" +
                                "Your Order Id is:"+orderId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private String submitNewOrder(String responseId,String email,String telephone,String contactName,
                                String latitude,String longitude,String pricingMethod) throws IOException {
        String url = serverAddress+"/api/OrderManagement/productOrder";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        String postJsonData="{\n" +
                "\t\"responseId\":\""+responseId+"\",\n" +
                "\t\"email\":\""+email+"\",\n" +
                "\t\"telephone\":\""+telephone+"\",\n" +
                "\t\"contactName\":\""+contactName+"\",\n" +
                "\t\"latitude\":\""+latitude+"\",\n" +
                "\t\"longitude\":\""+longitude+"\",\n" +
                "\t\"pricingMethod\":\""+pricingMethod+"\"\n" +
                "}";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postJsonData);
        wr.flush();
        wr.close();
//        this.responseId=con.getHeaderField("responseId");
//        String bakasha=con.getResponseMessage();
//        System.out.println(bakasha);
        int responseCode = con.getResponseCode();
        //System.out.println(responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();
        //System.out.println(response.toString());
        //System.out.println(con.getResponseMessage());
        return con.getHeaderField("orderId");
    }
}
