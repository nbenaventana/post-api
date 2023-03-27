package com.codeando.postapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exposures", schema = "public")
public class Exposure {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type", nullable = false, length = 50)
    private String type;
}
