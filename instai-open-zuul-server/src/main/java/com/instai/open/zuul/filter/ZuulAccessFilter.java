package com.instai.open.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.instai.open.utils.Conss;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
* @Description:    zuul的过滤器
* @Author:         yilei
* @CreateDate:     2019/9/24 15:12
* @Version:        1.0
*/
public class ZuulAccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(ZuulAccessFilter.class);


    /**
     *
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     pre：可以在请求被路由之前调用
     routing：在路由请求时候被调用
     post：在routing和error过滤器之后被调用
     error：处理请求时发生错误时被调用
     filterOrder：通过int值来定义过滤器的执行顺序
     shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。
     run：过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
     然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，当然我们也可以进一步优化我们的返回，
     比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
     *
     */

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
    *  访问校验过滤器，执行逻辑的方法
    * @author      yilei
    * @param       []
    * @return      java.lang.Object
    * @exception
    * @date        2019/9/24 16:21
    */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        String servletPath = request.getServletPath();
        String access_token = request.getParameter("access_token");
        /* token为空 *//*
        if (StringUtils.isEmpty(access_token)) {
            ctx.setSendZuulResponse(false);// 驳回路由访问
            ctx.setResponseStatusCode(401);
            String msg = "Token is null!";
            int code = Conss.SERVICE_ACCESS_CODE_TOKEN_INVALID;
            exceptionData(code, msg, response);
            return null;
        }
        /* token无效 *//*
        if (!jwtTokenHelper.invalid(authToken, Conss.TOKEN_TYPE_LOGINAUTH)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            String msg = "Token is invalid!";
            int code = Conss.SERVICE_ACCESS_CODE_TOKEN_INVALID;
            exceptionData(code, msg, response);
            return null;
        }
        /* token超时 *//*
        if (jwtTokenHelper.isTokenExpired(authToken)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            String msg = "Token time out!";
            int code = Conss.SERVICE_ACCESS_CODE_TOKEN_TIMEOUT;
            exceptionData(code, msg, response);
            return null;
        }
        JwtUserInfo info = jwtTokenHelper.getUserFromToken(authToken);
        /* 用户不存在或token非法 *//*
        if (info == null || info.getUserName() == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            String msg = "user is invalid!";
            int code = Conss.SERVICE_ACCESS_CODE_USER_INVALID;
            exceptionData(code, msg, response);
            return null;
        }
       /* List<String> authPaths = info.getAuthArray();
        *//* 用户没有任何权限 *//*
        if (authPaths == null || authPaths.isEmpty()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            String msg = "user no permission!";
            int code = Conss.SERVICE_ACCESS_CODE_NO_PERMISSION;
            exceptionData(code, msg, response);
            return null;
        }
        *//* 接口权限校验 *//*
        String[] authUrls = new String[authPaths.size()];
        authPaths.toArray(authUrls);
        *//* 无接口访问权限 *//*
        if (!servletPathCheck(servletPath, authUrls)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            String msg = "user no permission!";
            int code = Conss.SERVICE_ACCESS_CODE_NO_PERMISSION;
            exceptionData(code, msg, response);
            return null;
        }*/
        return null;
    }

    /**
     * 校验访问url是否不需要验证token
     *
     * @param path
     * @return
     */
    private boolean servletPathCheck(String path, String[] unCheckUrl) {
        boolean msg = false;
        if (path == null) {
            return true;
        }
        if (path.equals("/")) {
            return true;
        }
        path = (path.charAt(0) == '/') == true ? path.substring(1, path.length()) : path;
        path = (path.charAt(path.length() - 1) == '/') == true ? path.substring(0, path.length() - 1) : path;
        String[] pathArray = path.split("/");

        if (unCheckUrl != null && unCheckUrl.length > 0) {
            for (String sonUrl : unCheckUrl) {
                sonUrl = (sonUrl.charAt(0) == '/') == true ? sonUrl.substring(1, sonUrl.length()) : sonUrl;
                sonUrl = (sonUrl.charAt(sonUrl.length() - 1) == '/') == true ? sonUrl.substring(0, sonUrl.length() - 1)
                        : sonUrl;
                String[] gSonUrl = sonUrl.split("/");
                boolean jumpBreak = false;
                for (int y = 0; y < gSonUrl.length; y++) {
                    for (int i = 0; i < pathArray.length; i++) {
                        /* path层级对等比对 */
                        if (i == y) {
                            if (gSonUrl[y].equals("*") || gSonUrl[y].equals("**")) {
                                return true;
                            } else if (gSonUrl[y].equals(pathArray[i])) {
                                msg = true;
                            } else {
                                msg = false;
                                jumpBreak = true;
                                break;
                            }

                        }
                    }
                    if (jumpBreak) {
                        break;
                    }

                }
                if (msg) {
                    break;
                }
            }
        }
        return msg;

    }

    /**
     * 统一异常json格式返回
     *
     * @param msg
     * @param response
     */
  /*  private void exceptionData(int code, String msg, HttpServletResponse response) {
        ReturnData<String> result = new ReturnData<String>();
        result.setCode(code);
        result.setDesc(msg);
        result.setData(msg);
        String responseJSON = JSONObject.toJSONString(result);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.append(responseJSON);
    }*/
}
