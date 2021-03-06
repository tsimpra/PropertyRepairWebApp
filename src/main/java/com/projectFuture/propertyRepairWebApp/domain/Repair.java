package com.projectFuture.propertyRepairWebApp.domain;

import com.projectFuture.propertyRepairWebApp.enums.RepairType;
import com.projectFuture.propertyRepairWebApp.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="REPAIRS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repair {

    @Id
    @Column(name="repairID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="repairDate",nullable = false)
    private LocalDate repairDate;

    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable = false,columnDefinition ="varchar(255) default 'PENDING'" )
    private Status status;

    @Column(name="cost",nullable = false)
    private Double cost;

    @Column(name="address",length = 120,nullable = false)
    private String address;

    @ManyToOne(optional = false)
    @JoinColumn(name="userID",referencedColumnName = "userID")
    private User user;

    @Column(name="description",nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="repairType",nullable = false)
    private RepairType repairType;


}
