package com.transport.service.handle;

import com.transport.dto.PaymentDetailsDTO;
import com.transport.enums.PaymentMethod;
import com.transport.enums.TariffType;
import com.transport.form.PaymentDetailsForm;
import com.transport.model.Tariff;
import com.transport.repository.TariffRepository;
import com.transport.util.category.CategoryUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Класс для обработки первичных полученных данных payment details
 * из order.html
 * Created by user on 7/11/2016.
 */
@Service
public class PaymentDetailsHandlerImpl implements PaymentDetailsHandler {
    @Autowired
    private TariffRepository tariffRepository;

    @Override
    public PaymentDetailsDTO handlePaymentDetailsForm(PaymentDetailsForm paymentDetailsForm) {

        DateTime date = new DateTime(paymentDetailsForm.getMoveDate());

        int category = CategoryUtil.getCategoryByDateAndCompanyNameAndType(date,
                paymentDetailsForm.getCompany(), TariffType.valueOf(paymentDetailsForm.getTariff()).getType());

        Tariff tariff = tariffRepository.findByCompanyAndTariffType(paymentDetailsForm.getCompany(), category);

        BigDecimal moversRate = getMoverRateByQuantity(paymentDetailsForm, tariff);
        BigDecimal additionalTruckRate = BigDecimal.valueOf(tariff.getAdditionalTruckPrice());
        BigDecimal truckQuantity = BigDecimal.valueOf(paymentDetailsForm.getTruck() - 1);
        BigDecimal paymentMethodAdditionPrice;

        if (paymentDetailsForm.getPaymentMethod().equals(PaymentMethod.CASH.name())) {
            paymentMethodAdditionPrice = BigDecimal.ZERO;
        } else {
            paymentMethodAdditionPrice = BigDecimal.valueOf(tariff.getNotCashPay());
        }

        Double totalRatePerHour = paymentMethodAdditionPrice.add(
                moversRate.add(
                        additionalTruckRate.multiply(truckQuantity))).doubleValue();


        PaymentDetailsDTO detailsDTO = new PaymentDetailsDTO();
        detailsDTO.setRatePerHour(totalRatePerHour);
        return detailsDTO;
    }

    /**
     * Получает ставку грузчиков в зависимости от их количества и тарифа
     *
     * @param paymentDetailsForm
     * @param tariff
     */
    private BigDecimal getMoverRateByQuantity(PaymentDetailsForm paymentDetailsForm, Tariff tariff) {
        BigDecimal moversRate;
        switch (paymentDetailsForm.getMovers()) {
            case 2:
                moversRate = BigDecimal.valueOf(tariff.getTwoMoversPrice());
                break;
            case 3:
                moversRate = BigDecimal.valueOf(tariff.getThreeMoversPrice());
                break;
            case 4:
                moversRate = BigDecimal.valueOf(tariff.getFourMoversPrice());
                break;
            case 5:
                moversRate = BigDecimal.valueOf(tariff.getFiveMoversPrice());
                break;
            default:
                //TODO Добавить exception или  в лог сообщение о том, что не удалось корректно обсчитать коли-во муверов
                moversRate = BigDecimal.valueOf(tariff.getTwoMoversPrice());
                break;
        }
        return moversRate;
    }
}
