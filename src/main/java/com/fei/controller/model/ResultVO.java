package com.fei.controller.model; /**
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description:
 * @author fengzf fengzf@gstarcad.com
 * @date 2018/8/1 15:33
 * @version Vxxx (项目版本)
 * @redmine
 * @update @Description TODO(这里用一句话描述这个方法的作用)
 * @update @author fengzf fengzf@gstarcad.com
 * @update @date 2018/8/1 15:33
 */

/**
 * @ClassName: ResultVO.java
 * @Description:
 * @author: fengzf fengzf@gstarcad.com
 * @Date: 2018/8/1 15:33
 *
 */
public class ResultVO {

    //状态
    private Boolean status;

    //返回信息
    private String msg;

    //返回数据
    private Object data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
