package com.cydeo.service.impl;

import com.cydeo.dto.InstructorAssessmentDTO;
import com.cydeo.dto.LessonStudentDTO;
import com.cydeo.entity.InstructorAssessment;
import com.cydeo.entity.LessonStudent;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.InstructorAssessmentRepository;
import com.cydeo.repository.LessonStudentRepository;
import com.cydeo.service.LessonStudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonStudentServiceImpl implements LessonStudentService {

    private final LessonStudentRepository lessonStudentRepository;
    private final InstructorAssessmentRepository instructorAssessmentRepository;
    private final MapperUtil mapperUtil;

    public LessonStudentServiceImpl(LessonStudentRepository lessonStudentRepository, InstructorAssessmentRepository instructorAssessmentRepository, MapperUtil mapperUtil) {
        this.lessonStudentRepository = lessonStudentRepository;
        this.instructorAssessmentRepository = instructorAssessmentRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<LessonStudentDTO> findStudentsByInstructorId(Long id) {

        List<LessonStudent> students = lessonStudentRepository.findAllByLessonInstructorId(id);
        return students.stream().map(s-> mapperUtil.convert(s, LessonStudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public LessonStudentDTO findById(Long id) {
        return mapperUtil.convert(lessonStudentRepository.findById(id), LessonStudentDTO.class);
    }

//    @Override
//    public void assessStudent(InstructorAssessmentDTO instructorAssessment, Long lessonStudentId) {
//        instructorAssessment.setGradeDate(LocalDate.now());
//        LessonStudentDTO lessonStudent = findById(lessonStudentId);
//        instructorAssessment.setLessonStudent(lessonStudent);
//
//        instructorAssessmentRepository.save(mapperUtil.convert(instructorAssessment, InstructorAssessment.class));
//    }
}
