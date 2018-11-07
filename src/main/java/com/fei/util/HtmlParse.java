package com.fei.util;

import com.fei.entity.Comment;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HtmlParse {

	public static List<Comment> getData (String html) throws Exception{
		//获取的数据，存放在集合中
		List<Comment> datalist = new ArrayList<Comment>();
		//采用Jsoup解析
		Document doc = Jsoup.parse(html);
		//获取html标签中的内容
		Elements elements = doc.select("div#js_commentData").select("ul[class=detail_comment_list]> li");
//		Elements elements = doc.select("div#js_commentData").select("ul[class=detail_comment_list]").select("li");
		for (Element ele:elements) {
			String user_id = ele.select("p[class= user_id]").text();
			String user_type = ele.select("span[class=user_type]").text();  
			String score = ele.select("strong[class=score]").text();
			String comment_info = ele.select("p").get(1).nextElementSibling().text().replace(Jsoup.parse("&nbsp;").text(), "");
			String commentTips = ele.select("p[class=detail_comment_tips]").select("a").get(0).text();
			//创建一个对象，封装数据
			Comment xiechengModel = new Comment();
			xiechengModel.setUserId(user_id);
			xiechengModel.setUserType(user_type);
			xiechengModel.setScore(score);
			xiechengModel.setCommentInfo(comment_info);
			xiechengModel.setCommentTips(DateUtils.parseDate(commentTips,"yyyy-MM-dd HH:mm"));
			//将每一个对象的值，保存到List集合中
			datalist.add(xiechengModel);
		}
		//返回数据
		return datalist;
	}
}
