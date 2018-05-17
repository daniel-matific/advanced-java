package mmn16.exercise1_try2;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

    private PrintWriter output;
    private BufferedReader input;

    private Socket connectionA, connectionB;

    //constructor
    public ServerThread(Socket connectionA, Socket connectionB){
        this.connectionA = connectionA;
        this.connectionB = connectionB;
    }

    public void run(){
        try{

            while(true){
                try{
                    //Trying to connect and have conversation
                    //waitForConnection();
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
    /*private void waitForConnection() throws IOException{
        showMessage(" Waiting for someone to connect... \n");
        connectionA = server.accept();
        showMessage(" Now connected to " + connectionA.getInetAddress().getHostName());
    }*/

    //get stream to send and receive data
    private void setupStreams() throws IOException{
        output = new PrintWriter(connectionA.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(connectionA.getInputStream()));
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
            connectionA.close(); //Closes the connection between you can the client
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