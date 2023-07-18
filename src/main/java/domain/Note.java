package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "notepad")
public class Note {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private boolean archived; // 0=no 1=yes
    @Column
    private boolean deleted; // 0=no 1=yes



}
