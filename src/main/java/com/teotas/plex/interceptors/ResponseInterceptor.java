package com.teotas.plex.interceptors;

import com.teotas.plex.PlexAPIConnection;
import okhttp3.*;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;



public class ResponseInterceptor implements Interceptor {
    private PlexAPIConnection connection;

    public ResponseInterceptor(PlexAPIConnection connection){
        this.connection = connection;
    }

    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Response reqResponse = chain.proceed(original);

        if(reqResponse.header("Content-Type").toLowerCase().contains("xml")){
            String xmlToConvert = reqResponse.body().string();
            JSONObject convertedXML = XML.toJSONObject(xmlToConvert);
            ResponseBody newBody = ResponseBody.create(MediaType.parse("application/json"), convertedXML.toString());
            reqResponse = reqResponse.newBuilder().body(newBody).build();
        }

        return reqResponse;
    }
}
