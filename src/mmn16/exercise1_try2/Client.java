package mmn16.exercise1_try2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame{

    private JTextField userText;
    private JTextArea chatWindow;
    private PrintWriter output;
    private BufferedReader input;
    private String message = "";
    private String serverIP;
    private Socket connection;

    public static void main(String[] args) {
        Client charlie;
        charlie = new Client("localhost");
        charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        charlie.startRunning();
    }

    //constructor
    public Client(String host){
        super("Client");
        serverIP = host;
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

    //connect to server
    public void startRunning(){
        try{
            connectToServer();
            setupStreams();
            whileChatting();
        }catch(EOFException eofException){
            showMessage("\n Client terminated the connection");
        }catch(IOException ioException){
            ioException.printStackTrace();
        }finally{
            closeConnection();
        }
    }

    //connect to server
    private void connectToServer() throws IOException{
        showMessage("Attempting connection... \n");
        connection = new Socket(InetAddress.getByName(serverIP), 7777);
        showMessage("Connection Established! Connected to: " + connection.getInetAddress().getHostName());
    }

    //set up streams
    private void setupStreams() throws IOException{
        output = new PrintWriter(connection.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        showMessage("\n The streams are now set up! \n");
    }

    //while chatting with server
    private void whileChatting() throws IOException{
        ableToType(true);
        do{
            message = input.readLine();
            showMessage("\n" + message);
        }while(!message.equals("SERVER - END"));
    }

    //Close connection
    private void closeConnection(){
        showMessage("\n Closing the connection!");
        ableToType(false);
        try{
            output.close();
            input.close();
            connection.close();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    //send message to server
    private void sendMessage(String message){
        output.println("CLIENT - " + message);
        showMessage("\nCLIENT - " + message);
    }

    //update chat window
    private void showMessage(final String message){
        SwingUtilities.invokeLater(() -> chatWindow.append(message));
    }

    //allows user to type
    private void ableToType(final boolean tof){
        SwingUtilities.invokeLater(() -> userText.setEditable(tof));
    }
}