package io_coding;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2019/12/30 0030
 * @Version： 1.0
 */
public class IOClient {
    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        int i = 0;
        while ((i ++) < 3){
            new Thread(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 3333);
                    while (true) {
                        try {
                            String str = new Date() + ": hello world";
                            socket.getOutputStream().write((str).getBytes());
                            System.out.println(Thread.currentThread().getName()+" 客户端发送：" + str);
                            new Thread(() -> {
                                InputStream inputStream = null;
                                try {
                                    inputStream = socket.getInputStream();
                                    int len;
                                    byte[] data = new byte[1024];
                                // 按字节流方式读取数据
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(Thread.currentThread().getName()+" 客户端接受：" + new String(data, 0, len));
                                }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }).start();
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                }
            }).start();
        }
    }
}
