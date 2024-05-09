package com.brahmakumaris.bktestapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Table(name = "batches")
@Getter
@Setter
public class Batch {
    @Id
    private Long batchId;

    @Column(name = "batch_name")
    private String batchName;

    @OneToMany(mappedBy = "batch")
    private List<User> users;
}