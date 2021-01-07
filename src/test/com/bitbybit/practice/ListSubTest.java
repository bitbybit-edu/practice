package com.bitbybit.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListSubTest {

    @Test
    public void listSubTest() {
        List<String> stableProfitableUserPOS = new ArrayList<>();
        stableProfitableUserPOS.add("1");
        stableProfitableUserPOS.add("2");
        stableProfitableUserPOS.add("3");
        stableProfitableUserPOS.add("4");
        stableProfitableUserPOS.add("5");
        stableProfitableUserPOS.add("6");
        stableProfitableUserPOS.add("7");
        stableProfitableUserPOS.add("8");
        stableProfitableUserPOS.add("9");
        stableProfitableUserPOS.add("10");

        int batchNum = 3;
        int batchLoop = stableProfitableUserPOS.size() / batchNum + ((stableProfitableUserPOS.size() % batchNum) > 0 ? 1 : 0);
        for (int i = 0; i < batchLoop; i++) {
            int end = Math.min(stableProfitableUserPOS.size(), ((i + 1) * batchNum));
            List<String> stableProfitableUsrSub = stableProfitableUserPOS.subList((i * batchNum), end);
            System.out.println(stableProfitableUsrSub);
        }
    }
}
