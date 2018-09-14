package com.example.guava.eventbus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/********************************
 * @Title Event
 * @package com.example.guava.eventbus
 * @Description:TODO
 *
 * @author XCTY
 * @date 2018/9/14 17:07
 * @version
 *********************************/
@Setter
@Getter
@ToString
public class Event {
    /**
     * 时间标识
     */
    private String operator;

    /**
     * 数据
     */
    private List<Object> data;

    public Event(String operator, List<Object> data) {
        this.operator = operator;
        this.data = data;
    }
}
