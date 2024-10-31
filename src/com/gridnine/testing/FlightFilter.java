package com.gridnine.testing;

import java.util.List;

interface FlightFilter {
    /**
     * Метод для получения названия фильтра.
     *
     * @return Название фильтра, указанное
     * в поле filterName.
     */
    String getFilterName();

    /**
     * Метод для получения списка сегментов,
     * в соответствии
     * с условием фильтра в реализации.
     *
     * @param flights список перелетов.
     *
     * @return список сегментов, удовлетворяющих
     * условию реализации.
     */
    List<Flight> filterFlights(List<Flight> flights);
}