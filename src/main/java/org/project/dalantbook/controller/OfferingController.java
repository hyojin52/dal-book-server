package org.project.dalantbook.controller;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.OfferingCreateRequest;
import org.project.dalantbook.controller.request.OfferingUpdateRequest;
import org.project.dalantbook.controller.request.OfferingsCreateRequest;
import org.project.dalantbook.controller.response.ChurchMemberResponse;
import org.project.dalantbook.controller.response.OfferingResponse;
import org.project.dalantbook.controller.response.Response;
import org.project.dalantbook.service.OfferingService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/offering")
@RequiredArgsConstructor
public class OfferingController {

    private final OfferingService offeringService;

    @GetMapping("/prepare")
    public Response<List<ChurchMemberResponse>> getPrepareOfferings(
            @RequestParam(defaultValue = "주정헌금") String type,
            @RequestParam LocalDate date
            ) {
        return Response.success(offeringService.getPrepareOfferings(type, date));
    }

    @PostMapping("/plural")
    public Response<Void> createOfferings(@RequestBody OfferingsCreateRequest request) {
        offeringService.creteOfferings(request);
        return Response.success();
    }

    @PostMapping("/singular")
    public Response<Void> createOffering(@RequestBody OfferingCreateRequest request) {
        offeringService.creteOffering(request);
        return Response.success();
    }

    @PutMapping("/{offeringId}")
    public Response<Void> updateOffering(
            @PathVariable String offeringId,
            @RequestBody OfferingUpdateRequest request) {
        offeringService.updateOffering(offeringId, request);
        return Response.success();
    }

    @DeleteMapping("/{offeringId}")
    public Response<Void> deleteOffering(
            @PathVariable String offeringId) {
        offeringService.deleteOffering(offeringId);
        return Response.success();
    }

    @GetMapping("/{offeringId}")
    public Response<OfferingResponse> getOffering(
            @PathVariable String offeringId) {
        return Response.success(offeringService.getOffering(offeringId));
    }

    @GetMapping()
    public Response<Page<OfferingResponse>> getOfferings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String churchMemberId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) LocalDate date,
            Authentication authentication) {
        return Response.success(offeringService.getOfferings(page, size, date, type, churchMemberId, authentication.getName()));
    }
}
