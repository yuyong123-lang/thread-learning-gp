package org.yong.verifylambda;

/**
 * @author yuys
 * @date 2022-07-21
 * @description
 */
public class VerifyTest {

    public static void main(String[] args) {
        int number = 10;
        new Thread(() -> System.out.println(number));
    }

}
