package cn.enterprisys.web.commons.interceptors;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class ResourceNoCacheInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("randomNum", IdWorker.getIdStr());
        return true;
    }
}
