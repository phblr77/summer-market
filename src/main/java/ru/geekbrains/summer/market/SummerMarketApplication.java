package ru.geekbrains.summer.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SummerMarketApplication {
	// Домашнее задание:
	// ----
	// | 1. Добавить на фронтенд пункт Итого с price корзины
	// | 2. Доработать кнопки удалить товар из корзины и сделать кнопку "очистить корзину"
	// | 3. Добавить возможность в корзине менять количество товаров в позиции с помощью кнопок +/-
	// ----
	// 4. * Попробуйте сохранить заказ в БД

	public static void main(String[] args) {
		SpringApplication.run(SummerMarketApplication.class, args);
	}
}
