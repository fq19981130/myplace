package src.com.concurrency2.ab;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private final Socket socket;

    private volatile boolean running = true;

    @Override
    public void run() {
        //装饰器模式
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter printWriter = new PrintWriter(outputStream);){
            while (running){
                String message = br.readLine();
                if (message == null)
                    break;
                System.out.println("Come from client >"+ message);
                printWriter.write("echo"+message+"\n");
                printWriter.flush();
            }
        }catch (IOException e){
            this.running = true;
        }finally {
            this.stop();
        }
    }
    public void stop(){
        if (running){
            return;
        }
        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
}
