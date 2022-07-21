package org.yong.blockQueue;

/**
 * @author yuys
 * @date 2022-07-21
 * @description
 */
public class Request {

    private String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
