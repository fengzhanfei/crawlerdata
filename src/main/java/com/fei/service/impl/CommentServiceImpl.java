package com.fei.service.impl;
/**
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description:
 * @author fengzf fengzf@gstarcad.com
 * @date 2018/11/6 17:24
 * @version Vxxx (项目版本)
 * @redmine
 * @update @Description TODO(这里用一句话描述这个方法的作用)
 * @update @author fengzf fengzf@gstarcad.com
 * @update @date 2018/11/6 17:24
 */

import com.fei.entity.Comment;
import com.fei.mapper.CommentMapper;
import com.fei.service.CommentService;
import com.fei.util.HtmlParse;
import com.fei.util.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CommentServiceImpl.java
 * @Description:
 * @author: fengzf fengzf@gstarcad.com
 * @Date: 2018/11/6 17:24
 *
 */
@Service(value = "commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 从携程拉取数据
     * @param page
     */
    @Override
    public void getData(Integer page) throws Exception {
        HttpRequest httpRequest = new HttpRequest();
        for(int i = 0; i < page; i++){
            int pageNo = i;  //爬取的页数
            //拼接url
            String  everypageurl = "http://vacations.ctrip.com/grouptravel/p1740331s0"+"-comment-" + pageNo + ".html" ;
            //调用HttpRequest中的方法获取网页内容
            String html = httpRequest.getHTMLContentByHttpGetMethod(everypageurl,"utf-8");
            //针对每页的HTML,调用HtmlParse类中的方法进行解析
           List<Comment> datalist = HtmlParse.getData(html);

          if(datalist.size() > 0){
              commentMapper.insertBatch(datalist);
           }
        }

    }

}
