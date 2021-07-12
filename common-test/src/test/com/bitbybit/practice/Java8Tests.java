package com.bitbybit.practice;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Java8Tests {

    @Test
    public void test1() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTimeJST = LocalDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS));
        System.out.println(localDateTimeJST);
    }

    /**
     * 前30天日期
     */
    @Test
    public void test2() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusMonths(6L);

        String format = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        System.out.println(format);
    }

    /**
     * 前30天日期
     */
    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 1; i <= 3; i++) {
            LocalDateTime localDateTime1 = localDateTime.minusDays(30 * i);
            String format = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
            System.out.println(format);
        }

    }

    @Test
    public void test4() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime last = today.minusDays(30);
        LocalDateTime middle = last.minusDays(30);
        LocalDateTime head = middle.minusDays(30);
        String format1 = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        String format2 = last.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        String format3 = middle.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        String format4 = head.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
        System.out.println(format4);
    }


    @Test
    public void test5() {
        Consumer<String> con = System.out::println;
        con.accept("有一个参数，无返回值的用法（Consumer函数式接口）");

    }

    @Test
    public void test6() {
        BinaryOperator<Integer> binary = (x, y) -> x + y;
        System.out.println(binary.apply(1, 2));
    }

    @Test
    public void test7() {
        Supplier<List> supplier = ArrayList::new;
        System.out.println(supplier.get());
    }

    @Test
    public void test8() {
        Comparator<Integer> bb = Integer::compare;
        System.out.println(bb.compare(3, 2));
        Comparator<Integer> cc = (x, y) -> Integer.compare(x, y);
        System.out.println(cc.compare(3, 2));

        Comparator<Integer> dd = (x, y) -> x.compareTo(y);
        System.out.println(dd.compare(3, 2));
        Comparator<Integer> ee = Integer::compareTo;
        System.out.println(ee.compare(3, 2));

        // 一个参数
        Function<String, Emp> fun = address -> new Emp(address);
        Function<String, Emp> fun1 = Emp::new;
        System.out.println(fun1.apply("beijing"));

    }

    static class Emp {
        private String address;

        private String name;

        private Integer age;

        public Emp() {

        }

        public Emp(String address) {
            this.address = address;
        }

        public Emp(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Emp(String address, String name, Integer age) {
            super();
            this.address = address;
            this.name = name;
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Emp [address=" + address + ", name=" + name + ", age=" + age + "]";
        }

    }

}