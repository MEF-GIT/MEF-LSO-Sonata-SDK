package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("Duplicates")
public class ServiceSpecification {
    private JButton Submit;
    protected javax.swing.JPanel JPanel;
    private JComboBox accessMedium;
    private JComboBox classOfService;
    private JComboBox productType;
    private JTextField bandwidth;
    private JTextField maxPortSpeed;
    private JTextField date;
    private JComboBox interfaceType;
    private JTextField pricingTerm;
    private JComboBox bandwidthUnits;
    private JComboBox portSpeedUnit;
    private String serverAddress;
    final private String latitude;
    final private String longitude;
    private String response;
    private String responseId;
    private String price;

    public ServiceSpecification(String serverAddress,String latitude,String longitude) {
        this.latitude=latitude;
        this.longitude=longitude;
        this.serverAddress=serverAddress;
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(bandwidth.getText().length()==0 ||maxPortSpeed.getText().length()==0  ){
                    JOptionPane.showMessageDialog(null,"Please fill all the fields");
                }
                else{
                    try {
                        if(checkServiceability(interfaceType.getSelectedItem().toString(),accessMedium.getSelectedItem().toString()
                                ,classOfService.getSelectedItem().toString(),productType.getSelectedItem().toString(),bandwidth.getText()
                        ,maxPortSpeed.getText(),date.getText(),pricingTerm.getText())){
                            JOptionPane.showMessageDialog(null,"The Service you requested was successfully received.\nstatus code:201. \n");
                            callOrderForm();
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,"We cannot deliver the service you requested.\nStatus Code:400.");
                        e.printStackTrace();
                    }


                }

            }
        });
    }

    private void callOrderForm() {
        JFrame jFrame=new JFrame("Order Details");
        jFrame.setContentPane(new Order(response,responseId,serverAddress,price).JPanel);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private boolean checkServiceability(String interfaceType,String accessMedium,String classOfService,String productType
    ,String bandwidth,String maxPortSpeed,String date,String pricingTerm) throws IOException {
        String url = serverAddress+"/api/address/ServiceQualification";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        String postJsonData="{\n" +
                "\"ServiceabilityRequest\":{\n" +
                "\t\"servicesite\":{\n" +
                "\t\t\"siteaddresstype\":\"GeoGraphic\",\n" +
                "\t\t\"address\":{\n" +
                "\t\t\t\"GeoCode\":{\n" +
                "\t\t\t\t\"latitude\": \""+latitude+"\",\n" +
                "\t\t\t\t\"longitude\": \""+longitude+"\"\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\t\"EthernetServiceabilityRequestItem\":{\n" +
                "\t\t\t\"bandwidth\":\""+bandwidth+"\",\n" +
                "\t\t\t\"maxPortSpeed\":\""+maxPortSpeed+"\",\n" +
                "\t\t\t\"accessMedium\":\""+accessMedium+"\",\n" +
                "\t\t\t\"classOfService\":\""+classOfService+"\",\n" +
                "\t\t\t\"productCategory\":\"ETHERNET\",\n" +
                "\t\t\t\"productType\":\""+productType+"\",\n" +
                "\t\t\t\"pricingTerm\":\""+pricingTerm+"\",\n" +
                "\t\t\t\"desiredActivationDate\":\""+date+"\",\n" +
                "\t\t\t\"interfaceType\":\""+interfaceType+"\",\n" +
                "\t\t\t\"newEnniRequired\":\"false\"\n" +
                "\t\t   }\n" +
                "\t\t\n" +
                "  }\n" +
                "}";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postJsonData);
        wr.flush();
        wr.close();
        this.responseId=con.getHeaderField("responseId");
        this.price=con.getHeaderField("price");
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();
        this.response=response.toString();
        return responseCode==201;
    }
}