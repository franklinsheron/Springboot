package com.libmngmt.model;

import javax.persistence.*;

import lombok.*;
@Entity
@Table(name="authortbl")
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Author 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name="Author_Name")
    private String name;
}
