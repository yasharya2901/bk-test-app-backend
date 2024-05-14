package com.brahmakumaris.bktestapp.models.Section;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "options")
@Getter
@Setter
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @Column(name = "option_text")
    private String optionText;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
