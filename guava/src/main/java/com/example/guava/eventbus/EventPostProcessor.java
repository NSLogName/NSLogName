package com.example.guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/********************************
 * @Title EventPostProcessor
 * @package com.example.guava.eventbus
 * @Description:TODO
 *
 * @author XCTY
 * @date 2018/9/14 17:04
 * @version
 *********************************/
@SuppressWarnings("ALL")
@Component
public class EventPostProcessor implements BeanPostProcessor {
    @Autowired
    private EventBus eventBus;

    @Autowired
    private AsyncEventBus asyncEventBus;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getFields();
        Method[] methods = bean.getClass().getDeclaredMethods();
        if (methods == null || methods.length == 0) {
            return bean;
        }
        for (Method method : methods) {
            Subscribe subscribe = method.getAnnotation(Subscribe.class);
            if (subscribe != null) {
                eventBus.register(bean);
                asyncEventBus.register(bean);
            }
        }


        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getDeclaredMethods();
        if (methods == null || methods.length == 0) {
            return bean;
        }
        return bean;
    }
}
