package com.bitbybit.practice.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 传统的BIO模型  不涉及到网络只是用提供的类去写一个通信
 *
 * @author liulin
 */
public class BIODemo {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ServerSocket serverSocket = new ServerSocket(10000);
        while (!Thread.currentThread().isInterrupted()) {
            Socket accept = serverSocket.accept();
            executorService.submit(() -> {

            });
        }
    }
}


