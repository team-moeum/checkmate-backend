package com.checkmate.member.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum Grade {

    BRONZE ("브론즈 등급"),
    SILVER ("실버 등급"),
    GOLD ("골드 등급"),
    PLATINUM("플레티넘 등급"),
    DIAMOND("다이아몬드 등급"),
    MASTER("마스터 등급");

    private final String description;

    Grade(String description) {
        this.description = description;
    }

    @JsonCreator
    public static Grade parseInputValue(String value) {
        return Stream.of(Grade.values())
                .filter(grade -> grade.getDescription().equals(value))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("올바른 등급을 입력하세요"));
    }
}
