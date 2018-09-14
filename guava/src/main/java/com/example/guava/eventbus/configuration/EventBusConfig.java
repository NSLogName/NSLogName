package com.example.guava.eventbus.configuration;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/********************************
 * @Title EventBusConfig
 * @package com.example.guava.eventbus.configuration
 * @Description:TODO
 *
 * @author XCTY
 * @date 2018/9/14 16:57
 * @version
 *********************************/
@Configuration
public class EventBusConfig {
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

    @Bean
    public AsyncEventBus asyncEventBus() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("asyncEventBus-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(10, 15, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        return new AsyncEventBus(singleThreadPool);
    }
}
