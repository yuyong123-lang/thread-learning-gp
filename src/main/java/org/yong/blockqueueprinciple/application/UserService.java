package org.yong.blockqueueprinciple.application;

import org.yong.blockqueueprinciple.entity.User;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuys
 * @date 2022-07-21
 * @description 注册用户的案例 （注册用户然后给用户发送积分）
 */
public class UserService {

    private static BlockingQueue<User> userBlockingQueue = new ArrayBlockingQueue<>(10);

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    {
        handlerIntegral();
    }

    public void handlerIntegral() {
        executorService.execute(() -> {
            try {
                User user = userBlockingQueue.take();
                System.out.println("向" + user.getUsername() + "发送了10000积分");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static boolean registerUser(String username) {
        User user = new User(username);
        System.out.println("注册用户成功！！用户名为：" + user.getUsername());
        try {
            userBlockingQueue.put(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        new UserService();
        while (true) {
            System.out.println("请输入用户名：");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            registerUser(username);
        }
    }
}
