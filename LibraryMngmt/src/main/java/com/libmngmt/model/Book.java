package com.libmngmt.model;

import javax.persistence.*;

import lombok.*;
@Entity
@Table(name="booktbl")
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name="Title")
	    private String title;

	    // Other book attributes

	    @ManyToOne
	    @JoinColumn(name = "author_id")
	    private Author author;

	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;
}
