package com.cisol.sandbox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static final Integer PORT = 9900;
    public static String CHAR_SET = "GBK";

    public static void main(String[] args) {
        System.out.println("服务器启动...\n");
        if (args.length == 1) {
            CHAR_SET = args[0];
        }
        TCPServer server = new TCPServer();
        server.init();
    }

    public void init() {
        try {
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                // 处理这次连接
                new HandlerThread(client);
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;

        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }

        public void run() {
            try {
                // 读取客户端数据
                InputStream input = socket.getInputStream();
                byte[] contentRecv = new byte[1024];
                input.read(contentRecv);// 这里要注意和客户端输出流的写方法对应,否则会抛
                // EOFException
                // 处理客户端数据
                System.out.println("服务端收到:" + new String(contentRecv, CHAR_SET));

                // 向客户端回复信息
//                DataOutputStream out = new DataOutputStream(
//                        socket.getOutputStream());
//                System.out.println("服务端输入:");
//                // 发送键盘输入的一行
//                String s = new BufferedReader(new InputStreamReader(System.in))
//                        .readLine();
//                out.writeUTF(s);
//
//                out.close();
                input.close();
            } catch (Exception e) {
                System.out.println("服务器 run 异常: " + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}
