package com.bitbybit.practice.quote;

import java.util.logging.Logger;

public class QuotePractice {

    private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) {
        //方法引用测试
//        methodQuote();

        // = 引用测试
        Person aPerson = new Person("a");
        logger.info("aPerson的引用地址："+ System.identityHashCode(aPerson));
        Person bPerson = new Person("b");
        logger.info("bPerson的引用地址："+ System.identityHashCode(bPerson));
        Person cPerson = aPerson;
        logger.info("cPerson的引用地址："+ System.identityHashCode(cPerson));
        cPerson.setName("c");
        logger.info("aPerson：" + aPerson.toString());
        logger.info("cPerson：" + cPerson.toString());
        Person dPerson = bPerson;
        logger.info("dPerson:" + dPerson.toString());
        logger.info("dPerson的引用地址："+ System.identityHashCode(dPerson));
        bPerson = cPerson;
        logger.info("dPerson的引用地址："+ System.identityHashCode(dPerson));
        logger.info("bPerson的引用地址："+ System.identityHashCode(bPerson));
        logger.info("dPerson:" + dPerson.toString());
        logger.info("bPerson:" + bPerson.toString());
    }

    private static void methodQuote() {
        Person person = new Person();
        person.setName("a");
        personCrossTest(person);
        logger.info("方法执行后person:" + person.toString());
    }

    public static void personCrossTest(Person person) {
        logger.info("传入的person:" + person.toString());
        person = new Person();
        person.setName("b");
        logger.info("方法内重新赋值后person:" + person.toString());
    }

}
