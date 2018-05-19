package mmn16.exercise1_try2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class Client extends JFrame {

    private JTextField userText;
    private JTextArea chatWindow;
    private JButton connect, disconnect;
    private PrintWriter output;
    private BufferedReader input;
    private String serverIP;
    private int port;
    private Socket connection;
    private CountDownLatch doneSignal;

    public static void main(String[] args) {
        Client client;
        client = new Client();
        client.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // constructs the ui and handles the events that happen when pressing the buttons
    public Client(){
        super("Client");
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
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        connect = new JButton("Connect");
        connect.setBackground(Color.GREEN);
        connect.addActionListener(event -> new Thread(() -> {
            serverIP = JOptionPane.showInputDialog(null, "Please enter server IP:");
            try {
                port = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter server port:"));
                startRunning();
            }
            catch(NumberFormatException numberFormatException) {
                showMessage("\nPort must be a number!");
            }}).start()
        );
        disconnect = new JButton("Disconnect");
        disconnect.setBackground(new Color(215, 0, 0));
        disconnect.addActionListener(event -> {
                    try {
                        output.close();
                        input.close();
                        connection.close();
                        disconnect.setEnabled(false);
                    }
                    catch (IOException e) {
                        showMessage("\nConnection terminated.");
                    }
                }
        );
        disconnect.setEnabled(false);
        buttonPanel.add(connect);
        buttonPanel.add(disconnect);
        add(buttonPanel, BorderLayout.EAST);
        setSize(500, 250);
        setVisible(true);
        userText.requestFocusInWindow();
    }

    // handles creation of socket, streams and the data coming from the server
    private void startRunning(){
        try{
            connect.setEnabled(false);
            connection = new Socket(InetAddress.getByName(serverIP), port);
            disconnect.setEnabled(true);
            showMessage("Connected to: " + connection.getInetAddress().getHostName());
            output = new PrintWriter(connection.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while(!connection.isClosed()) {
                doneSignal = new CountDownLatch(1);
                new Thread(() -> {
                    try {
                        String message = input.readLine();
                        if(message != null) {
                            showMessage("\n" + message);
                        }
                        else {
                            disconnect.doClick();
                        }
                        doneSignal.countDown();
                    } catch(IOException e) {
                        showMessage("\nI/O Exception occurred.");
                    }
                }).start();
                doneSignal.await();
            }
        } catch(IOException  e){
            showMessage("\nI/O Exception occurred.");
            connect.setEnabled(true);
        }
        catch(InterruptedException e) {
            showMessage("\nThread was interrupted.");
        }
        catch(IllegalArgumentException e) {
            showMessage("\nPort number must be between 0 and 65535.");
            connect.setEnabled(true);
        }
    }

    // update chat window
    private void showMessage(final String message){
        SwingUtilities.invokeLater(() -> chatWindow.append(message));
    }
}