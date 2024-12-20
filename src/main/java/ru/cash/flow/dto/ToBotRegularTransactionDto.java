package ru.cash.flow.dto;

import lombok.Getter;
import lombok.Setter;
import ru.cash.flow.enums.ETransaction;
import ru.cash.flow.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ToBotRegularTransactionDto {
    private Long userId;
    private TransactionType type;
    private String categoryName;
    private String title;
    private BigDecimal amount;
    private Date date;
}
