package com.example.OlympiqueAPI.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "stadium")
    private Set<Event> events;
}
