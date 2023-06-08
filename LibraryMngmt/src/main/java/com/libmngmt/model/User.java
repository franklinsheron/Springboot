package com.libmngmt.model;
import javax.persistence.*;

import lombok.*;
@Entity
@Table(name="usertbl")
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name="User_Name")
    private String name;
}
