package org.framework.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * socket客户端
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-09-25 16:54
 * @Version 1.0
 */

public class TimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8086);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("query time order");
            System.out.println("-----------client send order sucess...");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readLine = bufferedReader.readLine();
            System.out.println("-----------client accept msg:"+readLine);
        } catch (IOException e) {

        } finally {

        }
    }
}
