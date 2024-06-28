package com.cydeo.service.impl;

import com.cydeo.dto.InstructorAssessmentDTO;
import com.cydeo.dto.LessonStudentDTO;
import com.cydeo.entity.InstructorAssessment;
import com.cydeo.entity.LessonStudent;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.InstructorAssessmentRepository;
import com.cydeo.repository.LessonStudentRepository;
import com.cydeo.service.InstructorAssessmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorAssessmentServiceImpl implements InstructorAssessmentService {

    private final InstructorAssessmentRepository instructorAssessmentRepository;
    private final LessonStudentRepository lessonStudentRepository;
    private final MapperUtil mapperUtil;

    public InstructorAssessmentServiceImpl(InstructorAssessmentRepository instructorAssessmentRepository, LessonStudentRepository lessonStudentRepository, MapperUtil mapperUtil) {
        this.instructorAssessmentRepository = instructorAssessmentRepository;
        this.lessonStudentRepository = lessonStudentRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<InstructorAssessmentDTO> findAllByLessonStudent(LessonStudentDTO dto) {
        List<InstructorAssessment> grades = instructorAssessmentRepository.findAllByLessonStudent(mapperUtil.convert(dto, LessonStudent.class));

        return grades.stream().map(g-> mapperUtil.convert(g, InstructorAssessmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void assessStudentById(InstructorAssessmentDTO dto, Long lessonStudentId) {
        LessonStudent lessonStudent = lessonStudentRepository.findById(lessonStudentId).get();
        dto.setGradeDate(LocalDate.now());
        dto.setLessonStudent(mapperUtil.convert(lessonStudent, LessonStudentDTO.class));
        instructorAssessmentRepository.save(mapperUtil.convert(dto, InstructorAssessment.class));
    }
}
