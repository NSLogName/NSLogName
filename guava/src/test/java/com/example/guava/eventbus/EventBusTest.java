package com.example.guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

/********************************
 * @Title EventBusTest
 * @package com.example.guava.eventbus
 * @Description:TODO
 *
 * @author XCTY
 * @date 2018/9/14 17:39
 * @version
 *********************************/
@Component
public class EventBusTest {
    @Autowired
    private AsyncEventBus asyncEventBus;

    public void sendEvent() {
        String uuidStr = UUID.randomUUID().toString();
        Event event = new Event(uuidStr, new ArrayList<Object>());
        asyncEventBus.post(event);
    }
}
