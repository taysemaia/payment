package br.com.nutrifood.payment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @NotNull
    @Positive
    private final BigDecimal value;

    @NotBlank
    @Size(max = 100)
    private final String name;

    @NotBlank
    @Size(max = 19)
    private final String number;

    @NotBlank
    @Size(max = 7)
    private final String expiration;

    @NotBlank
    @Size(min = 3, max = 3)
    private final String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private final Long orderId;

    @NotNull
    private final Long paymentMethodId;

    public Payment(final Long id, final BigDecimal value, final String name, final String number, final String expiration,
                   final String code, Status status, final Long orderId, final Long paymentMethodId) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.number = number;
        this.expiration = expiration;
        this.code = code;
        this.status = status;
        this.orderId = orderId;
        this.paymentMethodId = paymentMethodId;
    }
}
