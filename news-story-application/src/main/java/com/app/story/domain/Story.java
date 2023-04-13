package com.app.story.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "news_story")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Story {

    @Id
    // Todo: Come back here to fix generationType
//    @SequenceGenerator(name = "story_id_seq_gen" ,sequenceName = "story_id_seq")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "story_id_seq_gen")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "story_title", nullable = false)
    private String title;

    @Column(name = "story_link", nullable = false)
    private String link;

    @Column(name = "story_div", nullable = false)
    private Division division;

    @Column(name = "story_created_at")
    private Instant createdAt;
}
