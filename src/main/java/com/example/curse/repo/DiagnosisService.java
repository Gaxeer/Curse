package com.example.curse.repo;

import com.example.curse.model.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisService {



        private final DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisService(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }


    public Diagnosis findById(Long id) {
            return diagnosisRepository.getOne(id);
        }

        public List<Diagnosis> findAll() {
            return diagnosisRepository.findAll();
        }

        public Diagnosis saveDiagnosis(Diagnosis diagnosis) {
            return diagnosisRepository.save(diagnosis);
        }

        public void deleteById(Long id) {
            diagnosisRepository.deleteById(id);
        }

    }

