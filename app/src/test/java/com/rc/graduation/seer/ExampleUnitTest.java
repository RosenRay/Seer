package com.rc.graduation.seer;

import com.rc.graduation.seer.rxjavademo.RxJavaSimple;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void rxHelloWorld()throws Exception{
        RxJavaSimple testRxJava = new RxJavaSimple();
        testRxJava.testHelloWorld();
    }

    @Test
    public void rxScheduler()throws Exception{
        new RxJavaSimple().testScheduler();
    }
}