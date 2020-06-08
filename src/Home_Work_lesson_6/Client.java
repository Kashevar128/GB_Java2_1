package src.Home_Work_lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8125;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        System.out.println("Подключение к серверу выполнено");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        System.out.println("Сообщение от сервера: " + strFromServer);
                    }
                } catch (Exception e) {
                    System.out.println("Соединение разорвано");
                }
            }
        }).start();
    }

    public void closeConnection() {
        System.out.println("Работа клиента завершена");
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
            System.out.println("Введите сообщение для сервера:");
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
        Client client = new Client();
        client.openConnection();
        client.sendMessage();
    }
}
