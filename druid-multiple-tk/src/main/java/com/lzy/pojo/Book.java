package com.lzy.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * book
 * @author lianzhengying
 * @date 2022-01-05 15:16:41
 */
@Table(name = "book")
@Data
public class Book implements Serializable {
    /**
     */
    @Id
    private Long bid;

    /**
     */
    private String bname;

    /**
     */
    private Long bcount;

    /**
     */
    private String bauthor;

    private static final long serialVersionUID = 1L;
}