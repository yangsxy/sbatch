package cn.yuan.jndi;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="dataSourceFilter",urlPatterns="/*")
public class DataSourceFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} finally{
			boolean needClearFlag = isNeedClearFlag((HttpServletRequest) request);
            if(needClearFlag) {
            	DataSourceContextHolder.clearDSType();
            }
		}
	}
	 private boolean isNeedClearFlag(HttpServletRequest servletRequest) {
	        HttpServletRequest request = servletRequest;
	        String requestURI = request.getRequestURI();
	        for(String ext:extList){
	            if(requestURI.endsWith(ext)){
	                return false;
	            }
	        }
	        return true;
	    }

	    private static List<String> extList= Arrays.asList(".js",".css",".png",".jpg",".jpeg");
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
