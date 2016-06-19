import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
public class Server extends JFrame{
   private JTextField userText;
   private final JTextArea chatWindow;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private ServerSocket server;
   private Socket connection;        
    
   public Server(){
       super("SERVER INTERFACE");
       userText=new JTextField();
       userText.setEditable(false);
       userText.addActionListener((ActionEvent event) -> {
           sendMessage(event.getActionCommand());
           userText.setText("");
       });
       add(userText,BorderLayout.NORTH) ;
       chatWindow=new JTextArea();
       add(new JScrollPane( chatWindow));
       setSize(300,150);
       setVisible(true);
       
       
       
   } 
   
        public void startRunning(){
            try{
                server=new ServerSocket(5789,100);//port number and no of users waiting to connect to server
                while(true){
                    waitForConnection();
                    setUpStreams();
                    whileChatting();
                }
                
            }catch(IOException ioException){
            }
        }
        //wait for connection and setup connection
        public void waitForConnection() throws IOException
        {
             showMessage("Waiting for someone to connect........\n");
             connection=server.accept();
             showMessage("Now connected to"+connection.getInetAddress().getHostAddress());
        }
        
        //set up the stream to send and receive messages
        public void setUpStreams()throws IOException{
            output=new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input=new ObjectInputStream(connection.getInputStream());
            showMessage("\n Streams are now setup! \n");
            
        }
        //during chatting
        public void whileChatting() throws IOException{
            String message="You are now connected!";
            sendMessage(message);
            ableToType(true);
            
            do{
                try{
                      message=(String) input.readObject();
                      showMessage("\n"+message);
                }catch(ClassNotFoundException classNotFoundException ){
                    showMessage("Non-Recognizabe message sent\n");
                    
                    
                }
                
            }while(!message.equals("CLIENT - END"));
            //End of conversation when user types in "END"
        }
        //At the end of chat
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
        //send a message to client
        private void sendMessage(String message){
            try{
            output.writeObject("SERVER - "+message);
            output.flush();
            showMessage("\n SERVER - "+message);
            }catch(IOException ioException){
                chatWindow.append("ERROR : Sorry! That message cannot be sent ");
            }     
       
       }
        //update chat window
        public void showMessage(final String text){
            //make thread to update window
            SwingUtilities.invokeLater(() -> {
                chatWindow.append(text);
            });
        }
        
        
        private void ableToType(final boolean flag){
             SwingUtilities.invokeLater(() -> {
                 userText.setEditable(flag);
             });
        }
}
