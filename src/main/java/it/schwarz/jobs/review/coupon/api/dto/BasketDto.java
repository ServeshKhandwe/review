package it.schwarz.jobs.review.coupon.api.dto;

import it.schwarz.jobs.review.coupon.domain.entity.AmountOfMoney;
import it.schwarz.jobs.review.coupon.domain.entity.Basket;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record BasketDto(
        @NotNull
        @DecimalMin(value = "0.00")
        @DecimalMax(value = "10000.00")
        BigDecimal value
) {
    public Basket toBasket() {
        return new Basket(AmountOfMoney.of(value));
    }

}
