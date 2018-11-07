package com.fei.service;


/**
 * @author fengzf fengzf@gstarcad.com
 * @version Vxxx (项目版本)
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description:
 * @date 2018/11/6 17:24
 * @redmine
 * @update @Description TODO(这里用一句话描述这个方法的作用)
 * @update @author fengzf fengzf@gstarcad.com
 * @update @date 2018/11/6 17:24
 */
public interface CommentService {

    /**
     * 从携程拉取数据
     * @param page
     */
    public void getData(Integer page) throws Exception;
}
