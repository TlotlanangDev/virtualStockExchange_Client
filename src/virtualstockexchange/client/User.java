
package virtualstockexchange.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 *
 * @author Tlotlanang
 */

class User{
    private String loginUserName;
    private String loginPassWord;
    private String registerUserName;
    private String registerSurName;
    private String registerEmail;
    private String registerPhone;
    private String registerAddress;
    private String registerEducation;
    private String registerpassW;
    private String RegisterConPassW;
    private LocalDate regDateofBirth;
    private TextField logInNameField;
    private TextField loginPassField;
    
    
    connectionToServer connection = new connectionToServer();
    filesLoader loadFile = new filesLoader();
    Errors errors = new Errors();
 
    //get loginUserName
public String getLoginInput() {
        return loginUserName + loginPassWord;
    }

    void setLoginInput(String userName, String passWord, TextField logInNameField, TextField loginPassField, ActionEvent event){
        
        this.loginUserName = userName;
        this.loginPassWord = passWord;
        this.logInNameField = logInNameField;
        this.loginPassField = loginPassField;
        
        if(userName == null | userName.isEmpty()){
            
            errors.setFieldErrorReset(loginPassField);
            errors.getFieldErrorReset();
            errors.setFieldEmptyChecker(userName, logInNameField);
            errors.getFieldEmptyChecker();
            return;
        }else if(passWord == null | passWord.isEmpty()){
            errors.setFieldErrorReset(logInNameField);
            errors.getFieldErrorReset();
            errors.setFieldEmptyChecker(passWord, loginPassField);
            errors.getFieldEmptyChecker();
            return;
        }
      
    
        String initialMessage = "Login";
        String loggedInResponse = "LoggedIn";
        String notLoggedInResponse = "NotLoggedIn";
        
        Socket socket;
        try {
            socket = new Socket("127.0.0.1", 9000);
        
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
                    if(loginDetailResponse.equals(loggedInResponse)){
                    
                    String fxmlStringLink = "portfolio.fxml";
                    String cssFileLink= "mainCss.css";
                    String fxmlTittleLink = "PORTFOLIO";
                    loadFile.setFXMLFileLink(fxmlStringLink);
                    loadFile.getFXMLFileLink();
                    loadFile.setCssFileLink(cssFileLink);
                    loadFile.getCssFileLink();
                    loadFile.setFxmlTittleLink(fxmlTittleLink);
                    loadFile.getFxmlTittleLink();
                    loadFile.switchWindow(event);
            }else if(loginDetailResponse.equals(notLoggedInResponse)){
                    System.out.println("Not logged In");
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

    void setRegisterInput(String registerAddress) {
        this.registerAddress = registerAddress;
    }
    
    
    
   
}

    
