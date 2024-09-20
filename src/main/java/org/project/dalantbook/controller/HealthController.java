package org.project.dalantbook.controller;

import org.project.dalantbook.controller.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public Response<String> health() {
        return Response.success("OK");
    }

}
