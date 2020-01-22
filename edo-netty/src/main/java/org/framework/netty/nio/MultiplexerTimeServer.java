package org.framework.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * 多路复用类
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-09-26 14:31
 * @Version 1.0
 */

public class MultiplexerTimeServer implements Runnable {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean stop;



    /**
     * 初始化多路复用器、绑定端口
     *
     * @param port
     */
    public MultiplexerTimeServer(int port) {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port :"+port);
        } catch (IOException e) {

        } finally {
        }
    }



    private void handleInput(SelectionKey selectionKey) throws IOException{
        //处理新接入的请求
        if(selectionKey.isValid()){
            if(selectionKey.isAcceptable()){
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector,SelectionKey.OP_READ);

            }
        }
        //读取数据
        if(selectionKey.isReadable()){
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(byteBuffer);
            if(read > 0){
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                String body = new String(bytes,"UTF-8");
                System.out.println("the time server receive order:"+body);
                doWrite(socketChannel, LocalDate.now().toString());
            }
        }
    }

    private void doWrite(SocketChannel socketChannel,String response) throws IOException {
        byte[] bytes = response.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }

    @Override
    public void run() {
        try {
            selector.select(1000);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                handleInput(selectionKey);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void setStop() {
        this.stop = stop;
    }
}
