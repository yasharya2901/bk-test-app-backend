package com.brahmakumaris.bktestapp.models.Section;

import com.brahmakumaris.bktestapp.models.Test.Test;
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

    @Column(name = "ques_title")
    private String quesTitle;

    @Column(name = "ques_content", columnDefinition = "TEXT")
    private String quesContent;

    @Column(name = "ques_img")
    private String quesImg;

    @ManyToMany
    @JoinTable(
            name = "question_tags",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @Enumerated(EnumType.STRING)
    @Column(name = "ques_type")
    private QuesType quesType;

    @Column(name = "ques_key")
    private String quesKey;

    @Column(name = "ques_max_mark")
    private int quesMaxMark;

    // Column for if the section is skippable
    @Column(name = "is_skippable")
    private boolean isSkippable;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)  // Added cascade = CascadeType.ALL and orphanRemoval = true
    private List<Option> options;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)  // Added nullable = false
    private Section section;
}
