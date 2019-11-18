package org.framework.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * socket服务端
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-09-25 14:25
 * @Version 1.0
 */

public class TimeServer {
    private static final int SERVER_PORT=8086;


    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("--------------server start-------------port："+ SERVER_PORT);
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {

        } finally {
        }
    }

}
