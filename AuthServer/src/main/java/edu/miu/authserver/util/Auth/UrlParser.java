package edu.miu.authserver.util.Auth;

import org.springframework.stereotype.Component;

import javax.persistence.Convert;
import javax.servlet.http.HttpServletRequest;


public class UrlParser {
    public static String getUrl(HttpServletRequest req) {
        String reqUrl = req.getRequestURL().toString();
        String queryString = req.getQueryString();   // d=789
        if (queryString != null) {
            reqUrl += "?"+queryString;
        }
        return reqUrl;
    }
    public static String getURL(HttpServletRequest req) {

        //    String scheme = req.getScheme();             // http
        //  String serverName = req.getServerName();     // hostname.com
        //  int serverPort = req.getServerPort();        // 80
        String contextPath = req.getContextPath();   // /mywebapp
        String servletPath = req.getServletPath();   // /servlet/MyServlet
        String pathInfo = req.getPathInfo();         // /a/b;c=123
        String queryString = req.getQueryString();          // d=789

        // Reconstruct original requesting URL
        StringBuilder url = new StringBuilder();
//        url.append(scheme).append("://").append(serverName);
//
//        if (serverPort != 80 && serverPort != 443) {
//            url.append(":").append(serverPort);
//        }

        url.append(contextPath).append(servletPath);

        if (pathInfo != null) {
            url.append(pathInfo);
        }
        if (queryString != null) {
            url.append("?").append(queryString);
        }
        return url.toString();
    }
}
