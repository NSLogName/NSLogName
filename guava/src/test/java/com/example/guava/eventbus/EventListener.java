package com.example.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import org.springframework.stereotype.Component;

/********************************
 * @Title EventListener
 * @package com.example.guava.eventbus
 * @Description:TODO
 *
 * @author XCTY
 * @date 2018/9/14 17:45
 * @version
 *********************************/
@Component
public class EventListener implements EventAbstract<Event> {
    @Subscribe
    @Override
    public void handle(Event event) {
        System.out.println("当前处理的时间内容是：" + event);
    }
}