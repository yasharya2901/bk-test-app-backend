package com.brahmakumaris.bktestapp.controllers;

import com.brahmakumaris.bktestapp.models.Section.Question;
import com.brahmakumaris.bktestapp.services.serviceInterface.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-app/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/section/{sectionId}")
    public List<Question> getQuestionsBySectionId(@PathVariable Long sectionId) {
        return questionService.findBySectionId(sectionId);
    }

//    @GetMapping("/quesType/{quesType}")
//    public List<Question> findByQuesType(@PathVariable String quesType) {
//        return questionService.findByQuesType(quesType);
//    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

//    @GetMapping("/tag/id/{tagId}")
//    public List<Question> findByTagId(@PathVariable Long tagId) {
//        return questionService.findByTagId(tagId);
//    }

//    @GetMapping("/tag/name/{tagName}")
//    public List<Question> findByTagName(@PathVariable String tagName) {
//        return questionService.findByTagName(tagName);
//    }
}
