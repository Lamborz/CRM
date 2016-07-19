package com.transport.service.handle;

import com.transport.dto.ManagerDTO;
import com.transport.form.ManagerForm;

/**
 * Created by AK on 7/11/2016.
 */
public interface ManagerInfoHandler {

    /**
     * Метод обрабатывает получененную первичную информацию Manager  form
     * @param managerForm
     * @return заполненный DTO для отображения
     */
    ManagerDTO handleManagerForm(ManagerForm managerForm);
}
