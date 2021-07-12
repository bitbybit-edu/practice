package com.bitbybit.practice;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

    @Test
    public void multiply() {
        List<Long> a = new ArrayList<>();
        a.add(2L);
        a.add(2L);
        a.add(2L);
        a.add(2L);
        Long reduce = a.stream().reduce(1L, (c, d) -> c * d);
        System.out.println(reduce);
    }
}
