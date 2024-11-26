package com.home.Entities;

import java.sql.Time;

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
@Table(name="class_schedules")
public class ClassSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="subject_id", nullable = false)
	private Long subjectId;
	@Column(name="classroom_id", nullable = false)
	private Long classroomId;
	@Column(name="day_of_week", nullable = false)
	private String dayOfWeek;
	@Column(name="start_time", nullable = false)
	private Time startTime;
	@Column(name="end_time", nullable = false)
	private Time endTime;
	
}
