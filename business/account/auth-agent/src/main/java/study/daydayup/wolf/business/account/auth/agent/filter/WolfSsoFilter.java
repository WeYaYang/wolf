package study.daydayup.wolf.business.account.auth.agent.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.daydayup.wolf.business.account.auth.agent.Session;
import study.daydayup.wolf.business.account.auth.agent.config.AuthConfig;
import study.daydayup.wolf.business.account.auth.agent.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * study.daydayup.wolf.business.account.auth.agent.filter
 *
 * @author Wingle
 * @since 2019/12/4 5:12 下午
 **/
public class WolfSsoFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(WolfSsoFilter.class);
    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Resource
    private AuthConfig config;
    @Resource
    private Session session;


    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        session.init(request, response);

        if(isAccessDenied(request.getServletPath())){
            accessDeny(response);
            return;
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    private boolean isAccessDenied(String path) {
        if (isExcludedPath(path)) {
            return false;
        }

        if(null == session.get("accountId")) {
            return true;
        }

        Date now = new Date();
        Date expiredAt = (Date) session.get("expiredAt");
        return expiredAt.before(now);
    }

    private boolean isExcludedPath(String path) {
        if ( PATH_MATCHER.match(config.getAuthPath(), path) ) {
            return true;
        }

        String excludedPaths = config.getExcludedPaths();
        if ( excludedPaths == null) {
            return true;
        }

        if(0 == excludedPaths.trim().length()) {
            return true;
        }

        for (String excludedPath : excludedPaths.split(",") ) {
            if( PATH_MATCHER.match(excludedPath.trim(), path) ) {
                return true;
            }
        }

        return false;
    }

    private void accessDeny(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");

        StringBuilder failMessage = new StringBuilder();
        failMessage.append("{\"code\":");
        failMessage.append(config.getDenyCode());
        failMessage.append(", \"message\":\"");
        failMessage.append(config.getDenyMessage());
        failMessage.append("\", \"data\":\"\"}");

        response.getWriter().println(failMessage.toString());
    }
}
