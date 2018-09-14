package com.example.guava.eventbus;

/********************************
 * @Title EventAbstract
 * @package com.example.guava.eventbus
 * @Description:TODO
 *
 * @author XCTY
 * @date 2018/9/14 17:15
 * @version
 *********************************/
public interface EventAbstract<E> {
    /**
     * 事件处理接口
     *
     * @param event 事件
     */
    void handle(E event);
}
