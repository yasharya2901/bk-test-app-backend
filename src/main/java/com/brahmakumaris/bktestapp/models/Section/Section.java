package com.brahmakumaris.bktestapp.models.Section;

import com.brahmakumaris.bktestapp.models.Test.Test;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sections")
@Setter
@Getter
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    @Column(name = "section_name")
    private String sectionName;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)  // Added cascade = CascadeType.ALL and orphanRemoval = true
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)  // Added nullable = false
    private Test test;
}
