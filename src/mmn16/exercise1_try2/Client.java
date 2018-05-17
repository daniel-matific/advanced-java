package mmn16.exercise1_try2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame {

    private JTextField userText;
    private JTextArea chatWindow;
    private JPanel buttonPanel;
    private JButton connect, disconnect;
    private PrintWriter output;
    private BufferedReader input;
    private String message = "";
    private boolean terminate;
    private String serverIP;
    private int port;
    private Socket connection;

    public static void main(String[] args) {
        Client client;
        client = new Client();
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Client(){
        super("Client");
        terminate = false;
        userText = new JTextField();
        userText.addActionListener(event -> {
                    output.println(event.getActionCommand());
                    userText.setText("");
                }
        );
        add(userText, BorderLayout.SOUTH);
        chatWindow = new JTextArea();
        chatWindow.setEditable(false);
        add(new JScrollPane(chatWindow), BorderLayout.CENTER);
        buttonPanel = new JPanel(new GridLayout(2,1));
        connect = new JButton("Connect");
        connect.setBackground(Color.GREEN);
        connect.addActionListener(event -> {
                    new Thread(() -> {
                    serverIP = JOptionPane.showInputDialog(null, "Please enter server IP:");
                    port = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter server port:"));
                    startRunning(); }).start();
                }
        );
        disconnect = new JButton("Disconnect");
        disconnect.setBackground(Color.RED);
        disconnect.addActionListener(event -> {
                    terminate = true;
                }
        );
        buttonPanel.add(connect);
        buttonPanel.add(disconnect);
        add(buttonPanel, BorderLayout.EAST);
        setSize(300, 150);
        setVisible(true);
        userText.requestFocusInWindow();
    }

    public void startRunning(){
        try{
            connection = new Socket(InetAddress.getByName(serverIP), port);
            showMessage("Connected to: " + connection.getInetAddress().getHostName());
            output = new PrintWriter(connection.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while(!terminate) {
                message = input.readLine();
                showMessage("\n" + message);
            }

            output.println("END");

            output.close();
            input.close();
            connection.close();
        }
        catch(EOFException eofException){
            showMessage("\nClient terminated the connection");
        }
        catch(IOException ioException){}
    }

    //update chat window
    private void showMessage(final String message){
        SwingUtilities.invokeLater(() -> chatWindow.append(message));
    }
}