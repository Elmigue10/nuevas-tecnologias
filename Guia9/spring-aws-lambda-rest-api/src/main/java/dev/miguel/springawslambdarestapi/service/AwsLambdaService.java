package dev.miguel.springawslambdarestapi.service;

import dev.miguel.springawslambdarestapi.model.AwsLambdaResponse;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AwsLambdaService {

    @Value("${service.client.awslambdarestapi}")
    private String API_URL;

    public AwsLambdaResponse requestAwsLambdaRestApi(String name){
        AwsLambdaClient awsLambdaClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(AwsLambdaResponse.class))
                .logLevel(Logger.Level.FULL)
                .target(AwsLambdaClient.class, API_URL);

        return awsLambdaClient.requestAwsLambdaRestApi(name);
    }

}
