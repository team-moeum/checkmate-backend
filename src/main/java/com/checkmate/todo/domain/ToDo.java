package com.checkmate.todo.domain;

import com.checkmate.member.domain.Member;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ToDo")
@Getter
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 도전명

    private Boolean isCompleted; // 완료 여부

    private int stat; // 증가 스탯

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> cycle = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private Date startedDate; // 시작일

    @Temporal(TemporalType.DATE)
    private Date endedDate; // 종료일

    @Builder
    public ToDo(String title, Boolean isCompleted, int stat, Member member, Set<DayOfWeek> cycle, Date startedDate, Date endedDate) {
        this.title = title;
        this.isCompleted = isCompleted;
        this.stat = stat;
        this.member = member;
        this.cycle = cycle;
        this.startedDate = startedDate;
        this.endedDate = endedDate;
    }
}
