package org.project.dalantbook.controller;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.ChurchMemberCreateRequest;
import org.project.dalantbook.controller.request.ChurchMemberUpdateRequest;
import org.project.dalantbook.controller.response.ChurchMemberResponse;
import org.project.dalantbook.controller.response.Response;
import org.project.dalantbook.service.ChurchMemberService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/church-member")
@RequiredArgsConstructor
public class ChurchMemberController {

    private final ChurchMemberService churchMemberService;

    @PostMapping
    public Response<Void> createChurchMember(@RequestBody ChurchMemberCreateRequest request) {
        churchMemberService.create(request);
        return Response.success();
    }

    @GetMapping("{churchMemberId}")
    public Response<ChurchMemberResponse> getChurchMember(@PathVariable String churchMemberId) {
        return Response.success(churchMemberService.getChurchMember(churchMemberId));
    }

    @DeleteMapping("{churchMemberId}")
    public Response deleteChurchMember(@PathVariable String churchMemberId) {
        churchMemberService.deleteChurchMember(churchMemberId);
        return Response.success();
    }

    @GetMapping
    public Response<Page<ChurchMemberResponse>> getChurchMembers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return Response.success(churchMemberService.getChurchMembers(page,size));
    }

    @PutMapping("{churchMemberId}")
    public Response<Void> updateChurchMember(
            @PathVariable String churchMemberId,
            @RequestBody ChurchMemberUpdateRequest request) {
        churchMemberService.updateChurchMember(churchMemberId, request);
        return Response.success();
    }

}
