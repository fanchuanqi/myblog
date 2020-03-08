package com.example.demo.Interceptor;

import com.example.demo.Util.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author niwang
 * @Date 3/6
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("access_token");

        if (null!=token){

            boolean result = JWTUtil.verify(token);
            if (result){
                return true;
            }
        }
        return false;
    }

}
