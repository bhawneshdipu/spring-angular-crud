package com.bhawnesh.angular.crud.model;

import com.bhawnesh.angular.crud.util.GenericZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Table(name = "sample_model")
@Entity
@Data
public class SampleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "dob")
    @JsonDeserialize(using = GenericZonedDateTimeDeserializer.class)
    ZonedDateTime dob;
}
