package dev.miguel.springawslambdarestapi.controller;

import dev.miguel.springawslambdarestapi.model.AwsLambdaRequest;
import dev.miguel.springawslambdarestapi.service.AwsLambdaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AwsLambdaController {

    private AwsLambdaService awsLambdaService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("lambdaRequest", new AwsLambdaRequest());
        model.addAttribute("lambdaResponse", null);
        model.addAttribute("exist", false);
        return "index";
    }

    @PostMapping("/")
    public String requestAwsLambdaRestApi(AwsLambdaRequest request, Model model){
        model.addAttribute("lambdaRequest", new AwsLambdaRequest());
        model.addAttribute("lambdaResponse", awsLambdaService.requestAwsLambdaRestApi(request.getName()));
        model.addAttribute("exist", true);
        return "index";
    }
}
