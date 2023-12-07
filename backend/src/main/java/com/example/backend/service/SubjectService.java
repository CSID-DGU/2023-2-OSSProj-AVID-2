package com.example.backend.service;

import com.example.backend.controller.response.SubjectResponseDTO;
import com.example.backend.entity.SubjectEntity;
import com.example.backend.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public List<SubjectResponseDTO> getAllSubjects() {
        List<SubjectEntity> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(SubjectResponseDTO::new)
                .collect(Collectors.toList());
    }
}

