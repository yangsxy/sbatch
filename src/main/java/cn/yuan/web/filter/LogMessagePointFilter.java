package cn.yuan.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yuan.web.util.LogMessageUtils;

@WebFilter(filterName="logMessagePointFilter",urlPatterns="/*")
public class LogMessagePointFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			String uuid = req.getHeader(LogMessageUtils.KEY_MEESAGE_ID);
			LogMessageUtils.setMessagePoint(uuid);
			chain.doFilter(req, resp);
		} finally{
			LogMessageUtils.removeMessagePoint();
		}
	}

	@Override
	public void destroy() {
		
	}

}
