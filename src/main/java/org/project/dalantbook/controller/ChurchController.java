package org.project.dalantbook.controller;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.ChurchRequest;
import org.project.dalantbook.controller.response.ChurchResponse;
import org.project.dalantbook.controller.response.Response;
import org.project.dalantbook.service.ChurchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/church")
@RequiredArgsConstructor
public class ChurchController {

    private final ChurchService churchService;

    @PostMapping
    public Response<ChurchResponse> create(@RequestBody ChurchRequest request) {
        return Response.success(churchService.create(request));
    }
}
