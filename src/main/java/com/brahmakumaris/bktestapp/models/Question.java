package com.brahmakumaris.bktestapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quesId;

    @Column(name = "ques_content", columnDefinition = "TEXT")
    private String quesContent;

    @Column(name = "ques_img")
    private String quesImg;

    @Enumerated(EnumType.STRING)
    @Column(name = "ques_type")
    private QuesType quesType;

    @Column(name = "ques_key")
    private String quesKey;

    @Column(name = "ques_max_mark")
    private int quesMaxMark;

    @ManyToMany(mappedBy = "questions")
    private List<Test> tests;

    @OneToMany(mappedBy = "question")
    private List<Option> options;
}

