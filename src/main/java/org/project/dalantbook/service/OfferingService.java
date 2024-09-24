package org.project.dalantbook.service;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.OfferingCreateRequest;
import org.project.dalantbook.controller.request.OfferingUpdateRequest;
import org.project.dalantbook.controller.request.OfferingsCreateRequest;
import org.project.dalantbook.controller.response.ChurchMemberResponse;
import org.project.dalantbook.controller.response.OfferingResponse;
import org.project.dalantbook.domain.ChurchMemberEntity;
import org.project.dalantbook.domain.OfferingEntity;
import org.project.dalantbook.domain.respository.ChurchMemberRepository;
import org.project.dalantbook.domain.respository.OfferingRepository;
import org.project.dalantbook.exception.DalantBookApplicationException;
import org.project.dalantbook.exception.ErrorCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferingService {

    private final ChurchMemberRepository churchMemberRepository;
    private final OfferingRepository offeringRepository;


    public List<ChurchMemberResponse> getPrepareOfferings(String type, LocalDate date) {
        List<ChurchMemberResponse> result = churchMemberRepository.getPrepareOfferings(type, date)
                .stream().map(ChurchMemberResponse::of)
                .collect(Collectors.toList());
        
        return result;
    }

    public void creteOfferings(OfferingsCreateRequest request) {
        List<OfferingEntity> offeringEntities = new ArrayList<>();
        for (OfferingsCreateRequest.UserInfo userInfo : request.getUserInfo()) {
            OfferingEntity offeringEntity = new OfferingEntity();
            offeringEntity.setType(request.getType());
            offeringEntity.setDate(request.getDate().atStartOfDay());
            ChurchMemberEntity churchMemberEntity = churchMemberRepository.findById(userInfo.getChurchMemberId()).orElseThrow(() ->
                    new DalantBookApplicationException(ErrorCode.NOT_FOUND_CHURCH_MEMBER));
            offeringEntity.setChurchMember(churchMemberEntity);
            offeringEntity.setAmount(userInfo.getAmount());
            offeringEntity.setMemo(userInfo.getMemo());
            offeringEntities.add(offeringEntity);
        }
        offeringRepository.saveAll(offeringEntities);
    }

    public void creteOffering(OfferingCreateRequest request) {
        ChurchMemberEntity churchMemberEntity = churchMemberRepository.findById(request.getChurchMemberId()).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_CHURCH_MEMBER));

        OfferingEntity offeringEntity = new OfferingEntity();
        offeringEntity.setType(request.getType());
        offeringEntity.setDate(request.getDate().atStartOfDay());
        offeringEntity.setAmount(request.getAmount());
        offeringEntity.setMemo(request.getMemo());
        offeringEntity.setChurchMember(churchMemberEntity);
        offeringRepository.save(offeringEntity);
    }

    public void updateOffering(String offeringId, OfferingUpdateRequest request) {
        OfferingEntity offeringEntity = offeringRepository.findById(offeringId).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_OFFERING));
        offeringEntity.setDate(request.getDate().atStartOfDay());
        offeringEntity.setAmount(request.getAmount());
        offeringEntity.setMemo(request.getMemo());
        offeringEntity.setType(request.getType());
        offeringRepository.save(offeringEntity);
    }

    public void deleteOffering(String offeringId) {
        OfferingEntity offeringEntity = offeringRepository.findById(offeringId).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_OFFERING));
        offeringRepository.delete(offeringEntity);
    }

    public OfferingResponse getOffering(String offeringId) {
        OfferingEntity offeringEntity = offeringRepository.findById(offeringId).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_OFFERING));
        return OfferingResponse.of(offeringEntity);
    }

    public Page<OfferingResponse> getOfferings(
            int page, int size,
            LocalDate date, String type, String churchMemberId) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<OfferingResponse> result = offeringRepository.getOfferings(date,type, churchMemberId, pageable)
                .map(OfferingResponse::of);
        return result;


    }

}
