package com.yangbaobao.administrationtools.utils;

import com.yangbaobao.administrationtools.javabeans.Response;
import org.json.JSONObject;

import java.util.List;

public class ResponseUtils {

    public static String generateResponse(List data) {
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("success");
        response.setTotal(data.size());
        response.setData(data);
        return new JSONObject(response).toString();
    }

    public static String generateNonDataSuccessResponse() {
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("success");
        return new JSONObject(response).toString();
    }
}
