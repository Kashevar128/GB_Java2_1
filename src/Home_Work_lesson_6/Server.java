package src.Home_Work_lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8125;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    public void start(int port) throws  IOException{
        System.out.println("Сервер запущен, ожидание клиента");
        ServerSocket serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        System.out.println("Клиент подключился");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        System.out.println("Сообщение от клиента: " + strFromServer);
                    }
                } catch (Exception e) {
                    System.out.println("Соединение разорвано");
                }
            }
        }).start();
    }

    public void closeConnection() {
        System.out.println("Работа сервера завершена");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите сообщение для клиента:");
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("/end")) {
                closeConnection();
                System.exit(0);
            }
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ошибка отправки сообщения");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(PORT);
        server.sendMessage();

    }

}


