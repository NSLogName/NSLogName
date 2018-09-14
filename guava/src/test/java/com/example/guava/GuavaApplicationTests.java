package com.example.guava;

import com.example.guava.eventbus.EventBusTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableScheduling
public class GuavaApplicationTests {
    @Autowired
    private EventBusTest eventBusTest;

    @Test
    public void contextLoads() {
    }

    @Test
    public void eventBusTest() {
        eventBusTest.sendEvent();
    }

}
