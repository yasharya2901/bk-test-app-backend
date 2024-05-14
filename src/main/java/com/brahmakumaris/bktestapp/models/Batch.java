package com.brahmakumaris.bktestapp.models;

import com.brahmakumaris.bktestapp.models.Test.Test;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name = "batches")
@Getter
@Setter
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;

    @Column(name = "batch_name")
    private String batchName;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)  // Added cascade = CascadeType.ALL and orphanRemoval = true
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "batch_tests",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private List<Test> tests;
}
