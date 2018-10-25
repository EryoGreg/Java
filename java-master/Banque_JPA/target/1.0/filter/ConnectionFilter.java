/*package main.webapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
    FilterConfig filterConfig;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log("Initialisation du filtre");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //String loginURI = ServletHelper.getServletUrl(ServletHelper.SERVLET_LOGIN, req);

        if(!request.getRequestURI().equals(null)){
            response.sendRedirect(request.getContextPath() + "/");
            //res.sendRedirect(loginURI);

        }

    }

    @Override
    public void destroy() {
        filterConfig.getServletContext().log("Destruction du filtre");

    }
}
*/