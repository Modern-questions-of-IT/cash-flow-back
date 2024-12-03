package ru.cash.flow.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.cash.flow.entities.Category;
import ru.cash.flow.entities.User;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class RegularTransactionDto {
    private Integer userId;
    private String type;
    private Integer categoryId;
    private String title;
    private BigDecimal amount;
    private Date firstTransaction;
    private Integer day;
    private Integer month;
    private Integer year;
    private Date createdAt;
    private Date updatedAt;
}