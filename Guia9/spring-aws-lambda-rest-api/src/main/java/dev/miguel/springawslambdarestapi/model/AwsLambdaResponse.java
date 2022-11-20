package dev.miguel.springawslambdarestapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AwsLambdaResponse {

    private String success;

    private String message;

}
