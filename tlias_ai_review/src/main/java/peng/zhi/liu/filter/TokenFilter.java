package peng.zhi.liu.filter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import peng.zhi.liu.utils.JWT;

import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将请求和回复转换成httpservlet类型
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //获取请求路径
        String requestURL = String.valueOf(httpServletRequest.getRequestURL());
        //判断是否请求login页面，如果是就放行
        if(requestURL.contains("/login")){
            log.info("请求登录页面，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return ;
        }
        //获取token
        String token = httpServletRequest.getHeader("token");
        //不是的话判断是否有token，如果没有的话就设置状态码为401
        if(token==null||token.isEmpty()){
            log.info("登录失败，token为空");
            httpServletResponse.setStatus(401);
            return ;
        }
        //如果存在token，校验令牌,如果令牌错误，设置状态码为401
        try {
            Claims claims = JWT.parseJWT(token);
        }catch(Exception e){
            log.info("令牌解析错误,登录失败");
            httpServletResponse.setStatus(401);
            return ;
        }
        //令牌校验正确放行
        log.info("令牌解析正确，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
