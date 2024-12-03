package ru.cash.flow.dto;

import lombok.Getter;
import lombok.Setter;
import ru.cash.flow.entities.Category;
import ru.cash.flow.entities.User;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class TransactionDto {
    private Integer userId;
    private String type;
    private Integer categoryId;
    private String title;
    private BigDecimal amount;
    private Date date;
    private Boolean isRecurring;
    private Long frequency;
    private Date nextOccurrence;
    private Date createdAt;
    private Date updatedAt;

}