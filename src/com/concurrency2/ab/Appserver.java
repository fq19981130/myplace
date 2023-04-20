package src.com.concurrency2.ab;

import src.com.concurrency2.Sdesign.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Appserver extends Thread{

    private int port;

    private static final int DEFAULT_PORT = 12722;

    private volatile boolean start = true;

    private List<ClientHandler> clientHandlers = new ArrayList<>();

    private final  ExecutorService excutor = Executors.newFixedThreadPool(10);

    public Appserver(){
        this(DEFAULT_PORT);
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            while (start){
                Socket client = server.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                excutor.submit(clientHandler);
                this.clientHandlers.add(clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            this.dispose();
        }
    }

    private void dispose() {
        clientHandlers.stream().forEach(ClientHandler::stop);
        this.excutor.shutdown();

    }

    public Appserver(int port){
        this.port = port;
    }
    public void startserver() throws IOException {
        ServerSocket server = new ServerSocket(port);
    }
    public void shutdown(){
        this.start = false;
        this.interrupt();
    }
}
