package dev.miguel.springawslambdarestapi.service;

import dev.miguel.springawslambdarestapi.model.AwsLambdaResponse;
import feign.Param;
import feign.RequestLine;

public interface AwsLambdaClient {

    @RequestLine("GET /hello?name={name}")
    AwsLambdaResponse requestAwsLambdaRestApi(@Param("name") String name);

}
