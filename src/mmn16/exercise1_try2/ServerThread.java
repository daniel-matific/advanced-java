package mmn16.exercise1_try2;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class ServerThread extends Thread {

    private PrintWriter outputA, outputB;
    private BufferedReader inputA, inputB;
    private Socket connectionA, connectionB;
    private CountDownLatch doneSignal;
    private boolean aTerminate, bTerminate;

    public ServerThread(Socket connectionA, Socket connectionB){
        this.connectionA = connectionA;
        this.connectionB = connectionB;
        aTerminate = bTerminate = false;
    }

    // handles creation of socket, streams and the actual input transfer from one client to the other and vice versa
    public void run(){
        try{
            outputA = new PrintWriter(connectionA.getOutputStream(), true);
            inputA = new BufferedReader(new InputStreamReader(connectionA.getInputStream()));
            outputB = new PrintWriter(connectionB.getOutputStream(), true);
            inputB = new BufferedReader(new InputStreamReader(connectionB.getInputStream()));

            serverMessage("You can start chatting !");

            while(!aTerminate && !bTerminate) {
                doneSignal = new CountDownLatch(1);
                new Thread(() -> {
                    try {
                        String message = inputA.readLine();
                        if(message == null) {
                            aTerminate = true;
                        }
                        else {
                            sendMessage(message, true);
                        }
                        doneSignal.countDown();
                    } catch (IOException e) {
                        serverMessage("\nThread was interrupted.");
                    }
                }).start();
                new Thread(() -> {
                    try {
                        String message = inputB.readLine();
                        if(message == null) {
                            bTerminate = true;
                        }
                        else {
                            sendMessage(message, false);
                        }
                        doneSignal.countDown();
                    } catch (IOException e) {
                        serverMessage("\nThread was interrupted.");
                    }
                }).start();
                doneSignal.await();
            }

            if(aTerminate) {
                outputB.println("The other client has terminated the chat.");
            }
            else {
                outputA.println("The other client has terminated the chat.");
            }

            outputA.close();
            inputA.close();
            connectionA.close();
            outputB.close();
            inputB.close();
            connectionB.close();
        }
        catch(IOException e){
            serverMessage("\nI/O Exception occurred.");
        }
        catch(InterruptedException e) {
            serverMessage("\nThread was interrupted.");
        }
    }

    // send the message to the clients
    private void sendMessage(String message, boolean sentFromA){
        if(sentFromA) {
            outputA.println("Me: " + message);
            outputB.println("You: " + message);
        }
        else {
            outputA.println("You: " + message);
            outputB.println("Me: " + message);
        }
    }

    // server messages
    private void serverMessage(String message) {
        outputA.println("SERVER: " + message);
        outputB.println("SERVER: " + message);
    }

}