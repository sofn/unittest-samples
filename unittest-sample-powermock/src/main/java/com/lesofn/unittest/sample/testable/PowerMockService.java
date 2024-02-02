package com.lesofn.unittest.sample.testable;

import lombok.Getter;

import java.util.ArrayList;

/**
 * @author sofn
 * @date 2022-05-17 21:08
 */
public class PowerMockService {
    @Getter
    private int num;

    public String get(int index) {
        ArrayList<String> list = new ArrayList<>();
        return list.get(index);
    }

    public boolean pubIsExists(String logPath) {
        System.out.println("pubIsExists:" + logPath);
        return isExists(logPath);
    }

    private boolean isExists(String logPath) {
        System.out.println("isExists:" + logPath);
        return false;
    }


    public void pubLog(String logPath) {
        log(logPath);
    }

    private void log(String msg) {
        throw new RuntimeException("不应该执行此行代码");
    }


}
