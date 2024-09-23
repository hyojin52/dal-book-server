package org.project.dalantbook.service;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.ChurchMemberCreateRequest;
import org.project.dalantbook.controller.request.ChurchMemberUpdateRequest;
import org.project.dalantbook.controller.response.ChurchMemberResponse;
import org.project.dalantbook.domain.ChurchEntity;
import org.project.dalantbook.domain.ChurchMemberEntity;
import org.project.dalantbook.domain.respository.ChurchMemberRepository;
import org.project.dalantbook.domain.respository.ChurchRepository;
import org.project.dalantbook.exception.DalantBookApplicationException;
import org.project.dalantbook.exception.ErrorCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChurchMemberService {
    private final ChurchMemberRepository churchMemberRepository;
    private final ChurchRepository churchRepository;

    @Transactional
    public void create(ChurchMemberCreateRequest request) {
        ChurchEntity churchEntity = churchRepository.findById(request.getChurchId()).orElseThrow(
                () -> new DalantBookApplicationException(ErrorCode.NOT_FOUND_CHURCH)
        );

        ChurchMemberEntity churchMemberEntity = new ChurchMemberEntity();
        churchMemberEntity.setChurch(churchEntity);
        churchMemberEntity.setName(request.getName());
        churchMemberEntity.setMemo(request.getMemo());
        churchMemberRepository.save(churchMemberEntity);
    }

    @Transactional(readOnly = true)
    public ChurchMemberResponse getChurchMember(String churchMemberId) {
        ChurchMemberEntity churchMemberEntity = churchMemberRepository.findById(churchMemberId).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_CHURCH_MEMBER));
        return ChurchMemberResponse.of(churchMemberEntity);
    }

    @Transactional
    public void deleteChurchMember(String churchMemberId) {
        ChurchMemberEntity churchMemberEntity = churchMemberRepository.findById(churchMemberId).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_CHURCH_MEMBER));

        churchMemberRepository.delete(churchMemberEntity);
    }

    public Page<ChurchMemberResponse> getChurchMembers(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<ChurchMemberResponse> result = churchMemberRepository.findAll(pageable)
                .map(ChurchMemberResponse::of);
        return result;
    }

    public void updateChurchMember(String churchMemberId, ChurchMemberUpdateRequest request) {
        ChurchMemberEntity churchMemberEntity = churchMemberRepository.findById(churchMemberId).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_CHURCH_MEMBER));
        churchMemberEntity.setName(request.getName());
        churchMemberEntity.setMemo(request.getMemo());
        churchMemberRepository.save(churchMemberEntity);
    }

}
