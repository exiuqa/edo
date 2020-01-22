package org.framework.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;

/**
 *
 * socket服务端处理逻辑
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-09-25 16:23
 * @Version 1.0
 */

public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            while (true){
                String reader = bufferedReader.readLine();
                System.out.println("----------server accept msg:"+reader);
                if(reader == null){
                    break;
                }
                printWriter.println(LocalDate.now());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
