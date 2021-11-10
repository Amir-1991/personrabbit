package org.sohagorup.education.personrabbit.web.rest.api;

import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiUtil {
    public static void setExampleResponse(NativeWebRequest nativeWebRequest, String contentType, String example) {
        try {
            HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
            response.addHeader("Content-Type", contentType);
            response.getWriter().print(example);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
