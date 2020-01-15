package io_coding;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2019/12/30 0030
 * @Version： 1.0
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        // TODO 服务端处理客户端连接请求
        ServerSocket serverSocket = new ServerSocket(3335);

        // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();

                    // 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 按字节流方式读取数据
                            new Thread(() ->{
                                String str = new Date() + "服务端收到了" + ": hello world";
                                try {
                                    socket.getOutputStream().write((str).getBytes());
                                    System.out.println(Thread.currentThread().getName()+" 服务端发送："+str);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }).start();
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(Thread.currentThread().getName()+" 服务端接受："+new String(data, 0, len));
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();

                } catch (IOException e) {
                }

            }
        }).start();

    }
}
