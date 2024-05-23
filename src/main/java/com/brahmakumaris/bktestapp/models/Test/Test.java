package com.brahmakumaris.bktestapp.models.Test;

import com.brahmakumaris.bktestapp.models.Batch;
import com.brahmakumaris.bktestapp.models.Section.Section;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tests")
@Getter
@Setter
public class Test {
    @Id
    private Long testId;

    @Column(name = "test_name")
    private String testName;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date testStartTime;

    @Temporal(TemporalType.TIME)
    private Date testEndTime;

    @Column(name = "time_limit")
    private int timeLimit;

    @OneToMany(mappedBy = "test")
    private List<Section> sections;

    @Column(name = "passing_marks")
    private int passingMarks;

    @Column(name = "total_marks")
    private int totalMarks;

    @ManyToMany(mappedBy = "tests")
    private List<Batch> batches;
}
