package com.libmngmt.model;

import javax.persistence.*;

import lombok.*;
@Entity
@Table(name="categorytbl")
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name="Category_Name")
    private String name;
}
