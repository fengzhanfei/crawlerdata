package com.fei.controller;
 
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fei.controller.model.ResultVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 * @Author: fengzf fengzf@gstarcad.com
 * @MethodName:
 * @@Description: 
 * @params  
 * @return 
 * @Date:  2018/8/1 15:38 
 */  
@Controller
@Scope("prototype")
public class BaseAction {

	protected transient final Log logger = LogFactory.getLog(getClass());

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	


	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}



	/**
	 * Convenience method to get the request
	 * 
	 * @return current request
	 */
	protected HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * Convenience method to get the response
	 * 
	 * @return current response
	 */
	protected HttpServletResponse getResponse() {
		return response;
	}


	/**
	 * Convenience method to get the session. This will create a session if one
	 * doesn't exist.
	 * 
	 * @return the session from the request (request.getSession()).
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}


	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-Real-IP");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("X-Forwarded-For");
		}

		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")
					|| ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	/**
	 * 返回 context path
	 * 
	 * @return
	 */
	public String getBasePath() {
		StringBuffer ctx = new StringBuffer();

		ctx.append(request.getScheme() + "://" + request.getServerName());
		if (request.getScheme().equals("https")) {
			if (request.getServerPort() != 443) {
				ctx.append(":" + request.getServerPort());
			}
		} else if (request.getScheme().equals("http")) {
			if (request.getServerPort() != 80) {
				ctx.append(":" + request.getServerPort());
			}
		}else{
			ctx.append(":" + request.getServerPort());
		}
		ctx.append(request.getContextPath());
		return ctx.toString();
	}

	/**
	 * 操作成功
	 * @param data
	 * @return
	 */
	protected ResultVO operateSuccessFul(String msg,Object data){
		ResultVO vo = new ResultVO();
		vo.setStatus(true);
		vo.setMsg(msg);
		vo.setData(data);
		return vo;
	};

	/**
	 * 操作成功
	 * @return
	 */
	protected ResultVO operateSuccessFul(String msg){
		ResultVO vo = new ResultVO();
		vo.setStatus(true);
		vo.setMsg(msg);
		return vo;
	};

	/**
	 * 操作成功
	 * @return
	 */
	protected ResultVO operateFail(String msg){
		ResultVO vo = new ResultVO();
		vo.setStatus(false);
		vo.setMsg(msg);
		return vo;
	};
}
