package com.brahmakumaris.bktestapp.models;

import com.brahmakumaris.bktestapp.models.Test.Test;
import com.brahmakumaris.bktestapp.models.Test.TestState;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "mobile_number")
    private String mobNo;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "is_active")
    private Boolean isActive;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "test_states", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyJoinColumn(name = "test_id")
    @Column(name = "state")
    @Enumerated(EnumType.STRING)  // Specify that TestState should be persisted as a String
    private Map<Test, TestState> testStates;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Result> results;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;
}
