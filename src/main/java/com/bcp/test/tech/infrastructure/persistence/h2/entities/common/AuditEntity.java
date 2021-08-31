package com.bcp.test.tech.infrastructure.persistence.h2.entities.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntity {

    @CreatedDate
    @Column(name = "DAT_CRE")
    public Date createdDate;

    @LastModifiedDate
    @Column(name = "DAT_UPD")
    public Date updatedDate;

}
