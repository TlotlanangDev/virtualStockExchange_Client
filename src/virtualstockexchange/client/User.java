
package virtualstockexchange.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 *
 * @author Tlotlanang
 */

class User{
    private String loginUserName, loginPassWord;
    private String logInInputText;
    private TextField logInInputField;
    private String registerUserName, registerSurName, registerEmail, registerPhone, registerAddress, registerEducation, 
                   registerpassW, RegisterConPassW;
    private TextField logInNameField, regUserNameField, regSurNameField, regEMailField, regPhoneField;
    private TextArea regAddressArea, regEducationArea;
    private PasswordField loginPassField, regPassWordField, regConfirmPassField;
    private LocalDate regDateofBirth;
    
    
    connectionToServer connection = new connectionToServer();
    filesLoader loadFile = new filesLoader();
    Errors errors = new Errors();
 
    //get loginUserName
    public String getLoginInput() {
        return loginUserName + loginPassWord;
    }
    //send login data to the database and get a response
    void setLoginInput(String userName, String passWord, ActionEvent event){
        
        String initialMessage = "Login";
        String loggedInResponse = "LoggedIn";
        String notLoggedInResponse = "NotLoggedIn";
        int portNumber = 9000;
        String netWorkAddress = "127.0.0.1";
        
        Socket socket;
        try {
            socket = new Socket(netWorkAddress, portNumber);
        
        DataOutputStream outputstream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputstream = new DataInputStream(socket.getInputStream());
        
        connection.setConnectionPorts(socket);
        connection.getConnectionPorts();
        connection.setOutputDataStream(outputstream);
        connection.getOutputstream().writeUTF(initialMessage);
        connection.setInpuDataStream(inputstream);
        String serverInitialResponse = connection.getInputstream().readUTF();
        
        
        //After gettting a response, we send username and password to server to check if available on the database
        if(serverInitialResponse.equals(initialMessage)){
            
                
                    connection.setOutputDataStream(outputstream);
                    connection.getOutputstream().writeUTF(userName);
                    connection.getOutputstream().writeUTF(passWord);
                    connection.setInpuDataStream(inputstream);
                    String loginDetailResponse = connection.getInputstream().readUTF();
                    //if response is logged in we open portfolio, if notloggedin we return login error.
                    if(loginDetailResponse.equals(loggedInResponse)){
                    loadScene(event);
                    
                    }else if(loginDetailResponse.equals(notLoggedInResponse)){
                            System.out.println("UserName and Password do not match..");
                    }else{
                            System.out.println("LoggedIN/NotLogged response from server error!!!");
                         }
           
            //Close resources
            connection.setcloseSocket(socket);
            connection.getConnectionPorts();
            connection.setCloseInputStream(inputstream);
            connection.getInputstream();
            connection.setCloseOutputStream(outputstream);
            connection.getOutputstream();
            
        }else{
            System.out.println("Login response error!!");
        }
            } catch (IOException ex) {
                System.out.println("User: setlogInInput error!!(Cannot send Data to Server!!)");
            }
        
    } 

    public String getRegisterInput() {
        return registerAddress;
    }

    void setRegisterInput(String registerAddress,String registerUserName, String registerSurName, String registerEmail, 
                            String registerPhone, String registerEducation, String registerpassW, String RegisterConPassW, 
                            TextField regUserNameField, TextField regSurNameField, TextField regEMailField, TextField regPhoneField, 
                            TextArea regAddressArea, TextArea regEducationArea, PasswordField regPassWordField, 
                            PasswordField regConfirmPassField, LocalDate regDateofBirth) {
        this.registerUserName = registerUserName;
        this.registerSurName = registerSurName;
        this.registerEmail = registerEmail;
        this.registerPhone = registerPhone; 
        this.registerAddress = registerAddress;
        this.registerEducation = registerEducation;
        this.registerpassW = registerpassW;
        this.RegisterConPassW = RegisterConPassW;
        this.regUserNameField = regUserNameField;
        this.regSurNameField = regSurNameField;
        this.regEMailField = regEMailField;
        this.regPhoneField = regPhoneField;
        this.regAddressArea = regAddressArea;
        this.regEducationArea = regEducationArea;
        this.regPassWordField = regPassWordField;
        this.regConfirmPassField = regConfirmPassField;
        this.regDateofBirth = regDateofBirth;
                
    }
    
    //Load a different FXML file using the same stage and switching scenes
    private void loadScene(ActionEvent event) {
        
                    String fxmlStringLink = "portfolio.fxml";//FXML file link for portfolio
                    String cssFileLink= "mainCss.css";//CSS file link
                    String fxmlTittleLink = "PORTFOLIO";//FXML file tittle link
                    
                    loadFile.setFXMLFileLink(fxmlStringLink); //load fxml file
                    loadFile.getFXMLFileLink();
                    loadFile.setCssFileLink(cssFileLink); //load CSS file
                    loadFile.getCssFileLink();
                    loadFile.setFxmlTittleLink(fxmlTittleLink); //Change Title page
                    loadFile.getFxmlTittleLink();
                    loadFile.switchWindow(event);
    }
    
    
    
   
}

    
