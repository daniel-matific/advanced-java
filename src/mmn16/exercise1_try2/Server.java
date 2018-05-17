package mmn16.exercise1_try2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame {

    private JTextField userText;
    private JTextArea chatWindow;
    private PrintWriter output;
    private BufferedReader input;
    private ServerSocket server;
    private Socket connection;

    public static void main(String[] args) {
        Server sally = new Server();
        sally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sally.startRunning();
    }

    //constructor
    public Server(){
        super("Server");
        userText = new JTextField();
        userText.setEditable(false);
        userText.addActionListener(event -> {
                    sendMessage(event.getActionCommand());
                    userText.setText("");
                }
        );
        add(userText, BorderLayout.SOUTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(300, 150); //Sets the window size
        setVisible(true);
    }

    public void startRunning(){
        try{
            server = new ServerSocket(7777);
            while(true){
                try{
                    //Trying to connect and have conversation
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                }catch(EOFException eofException){
                    showMessage("\n Server ended the connection! ");
                } finally{
                    closeConnection(); //Changed the name to something more appropriate
                }
            }
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
    //wait for connection, then display connection information
    private void waitForConnection() throws IOException{
        showMessage(" Waiting for someone to connect... \n");
        connection = server.accept();
        showMessage(" Now connected to " + connection.getInetAddress().getHostName());
    }

    //get stream to send and receive data
    private void setupStreams() throws IOException{
        output = new PrintWriter(connection.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        showMessage("\n Streams are now setup \n");
    }

    //during the chat conversation
    private void whileChatting() throws IOException{
        String message = " You are now connected! ";
        sendMessage(message);
        ableToType(true);
        do{
            message = input.readLine();
            showMessage("\n" + message);
        }while(!message.equals("CLIENT - END"));
    }

    public void closeConnection(){
        showMessage("\n Closing Connections... \n");
        ableToType(false);
        try{
            output.close(); //Closes the output path to the client
            input.close(); //Closes the input path to the server, from the client.
            connection.close(); //Closes the connection between you can the client
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    //Send a message to the client
    private void sendMessage(String message){
        output.println("SERVER - " + message);
        showMessage("\nSERVER -" + message);
    }

    //update chatWindow
    private void showMessage(final String text){
        SwingUtilities.invokeLater(() -> chatWindow.append(text));
    }

    private void ableToType(final boolean tof){
        SwingUtilities.invokeLater(() -> userText.setEditable(tof));
    }
}