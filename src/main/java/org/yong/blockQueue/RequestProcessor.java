package org.yong.blockQueue;

/**
 * @author yuys
 * @date 2022-07-21
 * @description
 */
public interface RequestProcessor {

    void processRequest(Request request);

    void shutdown();
}
