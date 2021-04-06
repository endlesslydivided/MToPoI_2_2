package main.java.ClientApp.Server;

import ClientApp.Server.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    public static final int PORT = 4004;
    public static LinkedList<ServerThread> serverThreads = new LinkedList<>();
    public static ClientApp.Server.MessageStory messageStory = new ClientApp.Server.MessageStory();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Сервер запущен!");
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverThreads.add(new ClientApp.Server.ServerThread(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}