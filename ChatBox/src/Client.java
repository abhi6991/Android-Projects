import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
public class Client extends JFrame{
    private JTextField userText;
    private final JTextArea chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream  input;
    private String message="";
    private final String serverIP;
    private Socket connection;
    
    //constructor
    public Client(String host){
        super("Client Interface");
        serverIP = host;
        userText=new JTextField();
        userText.setEditable(false);
        userText.addActionListener((ActionEvent event) -> {
            sendData(event.getActionCommand());
            userText.setText("");
        });
        add(userText,BorderLayout.NORTH);
        chatWindow=new JTextArea();
        add(new JScrollPane(chatWindow),BorderLayout.CENTER);
        setSize(300,150);
        setVisible(true);
    }
    
    //connect to server
    public void startRunning(){
        try{
            connectToServer();
            setUpStreams();
            whileChatting();
        }catch(EOFException eofException ){
            showMessage("\nClient Terminated the Connection!\n");
            
        }catch(IOException ioException){
        }finally{
            //close the connection
            closeCrap();
        }
    }
    
    //connect to server
    private void connectToServer() throws IOException{
        showMessage("Attempting Connection.......\n");
        connection=new Socket(InetAddress.getByName(serverIP),5789);
        showMessage("Connected To :"+connection.getInetAddress().getHostName());
        
    }
    
    //set up streams
    public void setUpStreams()throws IOException{
            output=new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input=new ObjectInputStream(connection.getInputStream());
            showMessage("\n Streams are now setup! \n");
            
        }
    
    //while chatting with the server
    private void whileChatting()throws IOException{
        ableToType(true);
        //String message="";
         do{
             try{
                 message = (String) input.readObject();
                 showMessage("\n"+message);
             }catch(ClassNotFoundException classNotFoundException){
                 showMessage("\n Unrecognizible Text!\n");
                 
             }
         }while(!message.equals("SERVER - END"));
    }
    
    //close the streams and socket
      private void closeCrap(){
            showMessage("\nClosing the Connection.....\n");
            ableToType(false);
            try{
            input.close();
            output.close();
            connection.close();
            }catch(IOException ioException){
            }        
            
       }
      
      //send message to the server
        private void sendData(String message){
            try{
            output.writeObject("CLIENT - "+message);
            output.flush();
            showMessage("\n CLIENT - "+message);
            }catch(IOException ioException){
                chatWindow.append("ERROR : Sorry! That message could not be sent ");
            }     
       
       }
        
        //change/update chat window
         public void showMessage(final String text){
            //make thread to update window
            SwingUtilities.invokeLater(() -> {
                chatWindow.append(text);
            });
        }
         //give permission to type
          private void ableToType(final boolean flag){
             SwingUtilities.invokeLater(() -> {
                 userText.setEditable(flag);
             });
        }
      
    
}
