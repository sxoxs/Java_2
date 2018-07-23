package logik.Lesson_6.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final String IP_ADRESS = "localhost";
    final int PORT = 8189;
    private DataInputStream clientInStream = null;
    private DataOutputStream clientOutStream = null;
    private Scanner sc = null;
    private Socket socket = null;

    public void clientStart() {
        try {
            socket = new Socket(IP_ADRESS, PORT);
            clientInStream = new DataInputStream(socket.getInputStream());
            clientOutStream = new DataOutputStream(socket.getOutputStream());
            sc = new Scanner(System.in);
            System.out.println("Клиент подключился");

            Thread tIn = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = clientInStream.readUTF();
                            if (str.equals("/server_close")) {
                                System.out.println("Сервер отключился");
                                break;
                            }
                            System.out.println(str);
                        }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });

            Thread tOut = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = sc.nextLine();
                            if (str.equals("/end")) {
                                clientOutStream.writeUTF("/client_close");
                                System.out.println("Отключение...");
                                break;
                            }
                            clientOutStream.writeUTF(str);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            socket.close();
                            System.out.println("Отключено");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            tOut.setDaemon(true);

            tIn.start();
            tOut.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
