package com.brahmakumaris.bktestapp.models;

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

    @OneToMany(mappedBy = "section")
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
}
