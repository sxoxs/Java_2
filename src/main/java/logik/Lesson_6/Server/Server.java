package logik.Lesson_6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private DataInputStream serverInStream = null;
    private DataOutputStream serverOutStream = null;
    private Scanner sc = null;
    private ServerSocket serverSocket = null;
    private Socket socket = null;

    public void serverStart(){
        try {
            System.out.println("Сервер запускается");
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            serverInStream = new DataInputStream(socket.getInputStream());
            serverOutStream = new DataOutputStream(socket.getOutputStream());
            sc = new Scanner(System.in);

            Thread tIn = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        while (true) {
                            String str = serverInStream.readUTF();
                            if (str.equals("/client_close")) {
                                System.out.println("Клиент отключился");
                                System.out.println("Отключение...");
                                break;
                            }
                            System.out.println("Client: " + str);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            serverSocket.close();
                            System.out.println("Server soket close");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                            System.out.println("soket close");
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
                                System.out.println("Отключение...");
                                serverOutStream.writeUTF("/server_close");
                                break;
                            }
                            serverOutStream.writeUTF("serv: " + str);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            serverSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
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
