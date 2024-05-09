package com.brahmakumaris.bktestapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "mobile_number")
    private String mobNo;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "test_states", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyJoinColumn(name = "test_id")
    @Column(name = "state")
    private Map<Test, TestState> testStates;

    @OneToMany(mappedBy = "user")
    private List<Result> results;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;
}

