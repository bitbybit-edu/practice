package com.bitbybit.practice;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class ListTests {

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

    @Test
    public void distinctAddAll() {
        RealSportBetAble realSportBetAble1 = new RealSportBetAble("1",1);
        RealSportBetAble realSportBetAble2 = new RealSportBetAble("2",1);
        RealSportBetAble realSportBetAble3 = new RealSportBetAble("3",1);
        RealSportBetAble realSportBetAble4 = new RealSportBetAble("4",1);
        RealSportBetAble realSportBetAble5 = new RealSportBetAble("1",2);
        RealSportBetAble realSportBetAble6 = new RealSportBetAble("2",2);
        RealSportBetAble realSportBetAble7 = new RealSportBetAble("5",2);
        List<RealSportBetAble> list1 = new ArrayList<>(List.of(realSportBetAble1, realSportBetAble2, realSportBetAble3, realSportBetAble4));
        List<RealSportBetAble> list2 = List.of(realSportBetAble5, realSportBetAble6, realSportBetAble7);
        list1.addAll(list2);
        System.out.println(JSON.toJSONString(list1));
        List<RealSportBetAble> collect = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        Collection<RealSportBetAble> values = list1.stream().collect(Collectors.toMap(k -> k.eventId + k.count, v -> v, (left, right) -> right)).values();
        list1 = List.copyOf(values);
        System.out.println(JSON.toJSONString(list1));


    }

    public class RealSportBetAble {
        private String sportId;
        private String eventId;
        private Integer product;
        private Integer count;
        private String versionId;
        private Timestamp createTime;

        RealSportBetAble() {

        }

        RealSportBetAble(String eventId, Integer count) {
            this.eventId = eventId;
            this.count = count;
        }

        public String getSportId() {
            return sportId;
        }

        public void setSportId(String sportId) {
            this.sportId = sportId;
        }

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public Integer getProduct() {
            return product;
        }

        public void setProduct(Integer product) {
            this.product = product;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getVersionId() {
            return versionId;
        }

        public void setVersionId(String versionId) {
            this.versionId = versionId;
        }

        public Timestamp getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Timestamp createTime) {
            this.createTime = createTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RealSportBetAble that = (RealSportBetAble) o;

            if (!Objects.equals(eventId, that.eventId)) return false;
            if (!Objects.equals(count, that.count)) return false;
            return true;
        }

    }

}
