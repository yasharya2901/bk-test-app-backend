package com.brahmakumaris.bktestapp.models;

import com.brahmakumaris.bktestapp.models.Section.Question;
import com.brahmakumaris.bktestapp.models.Test.Test;
import com.brahmakumaris.bktestapp.models.Test.TestState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Entity
@Table(name = "results")
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Added nullable = false
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)  // Added nullable = false
    private Test test;

    private TestState testState;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "question_marks", joinColumns = @JoinColumn(name = "result_id"))
    @MapKeyJoinColumn(name = "question_id")
    @Column(name = "marks")
    private Map<Question, Integer> marks;

    @Column(name = "total_marks")
    private int totalMarks;
}
