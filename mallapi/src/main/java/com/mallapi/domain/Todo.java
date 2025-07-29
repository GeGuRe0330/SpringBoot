package com.mallapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "TODO_SEQ_GEN", sequenceName = "TODO_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "tbl_todo")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TODO_SEQ_GEN")
    private Long tno;
    private String title;
    private String writer;
    private boolean complete;
    private LocalDate dueDate;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeComplete(boolean complete) {
        this.complete = complete;
    }

    public void changeDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
