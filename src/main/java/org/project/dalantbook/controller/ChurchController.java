package org.project.dalantbook.controller;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.ChurchRequest;
import org.project.dalantbook.controller.response.ChurchResponse;
import org.project.dalantbook.controller.response.Response;
import org.project.dalantbook.service.ChurchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/church")
@RequiredArgsConstructor
public class ChurchController {

    private final ChurchService churchService;

    @PostMapping
    public Response<ChurchResponse> create(@RequestBody ChurchRequest request) {
        return Response.success(churchService.create(request));
    }

    @GetMapping
    public Response<Page<ChurchResponse>> getChurch(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return Response.success(churchService.getChurch(page, size));
    }
}
