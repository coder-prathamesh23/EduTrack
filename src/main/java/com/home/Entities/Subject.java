package com.home.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "course_id", nullable = false)
	private Long courseId;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "department_id")
	private Long departmentId;
}
