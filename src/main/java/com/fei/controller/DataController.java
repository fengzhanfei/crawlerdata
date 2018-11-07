package com.fei.controller;/**
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description:
 * @author fengzf fengzf@gstarcad.com
 * @date 2018/11/6 17:08
 * @version Vxxx (项目版本)
 * @redmine
 * @update @Description TODO(这里用一句话描述这个方法的作用)
 * @update @author fengzf fengzf@gstarcad.com
 * @update @date 2018/11/6 17:08
 */

import com.fei.controller.model.ResultVO;
import com.fei.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName: DataController.java
 * @Description:
 * @author: fengzf fengzf@gstarcad.com
 * @Date: 2018/11/6 17:08
 *
 */
@RestController
@RequestMapping(value = "/api")
public class DataController extends BaseAction{
    @Autowired
    private CommentService  commentService;

    /**
     * 拉取数据
     * @param page
     * @return
     */
    @RequestMapping(value = "/getData", produces = {"application/json;charset=UTF-8"})
    public ResultVO getData(@RequestParam(name = "page",required = false , defaultValue = "1") Integer page){
        try{
            commentService.getData(page);
            return operateSuccessFul("获取数据成功！");
        }catch(Exception e){
            e.printStackTrace();
            e.printStackTrace();
            return operateFail(e.getMessage());
        }
    }

}
