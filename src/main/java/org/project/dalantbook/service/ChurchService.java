package org.project.dalantbook.service;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.ChurchRequest;
import org.project.dalantbook.controller.response.ChurchResponse;
import org.project.dalantbook.domain.ChurchEntity;
import org.project.dalantbook.domain.respository.ChurchRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChurchService {

    private final ChurchRepository churchRepository;

    public ChurchResponse create(ChurchRequest request) {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setName(request.getName());
        churchEntity.setPastor(request.getPastor());
        churchEntity.setDenomination((request.getDenomination()));
        churchEntity.setAddress(request.getAddress());
        churchEntity.setPhone(request.getPhone());
        ChurchEntity saved = churchRepository.save(churchEntity);
        return ChurchResponse.of(saved);
    }
}
