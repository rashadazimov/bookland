package com.bookland.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Table
@Data
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fid;

    private Integer id;
    private String username;

    @Column
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> bookIdList;

    private Double totalPrice;
}
