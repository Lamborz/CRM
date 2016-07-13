package com.transport.service.handle;

import com.transport.ServiceApplication;
import com.transport.dto.PaymentDetailsDTO;
import com.transport.enums.Company;
import com.transport.enums.PaymentMethod;
import com.transport.enums.Rate;
import com.transport.enums.TariffType;
import com.transport.form.PaymentDetailsForm;
import com.transport.model.Tariff;
import com.transport.repository.TariffRepository;
import com.transport.repository.VehicleRepository;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Класс для тестирования методов обработки первичных данных
 * paymentDetails из order.html
 *
 * testHandlePaymentDetailsFormByMonday - проверка обработки данных на основании даты понедельник
 * testHandlePaymentDetailsFormByTuesday - проверка обработки данных на основании даты понедельник
 * testHandlePaymentDetailsFormByWednesday - проверка обработки данных на основании даты понедельник
 * testHandlePaymentDetailsFormByThursday - проверка обработки данных на основании даты понедельник
 * testHandlePaymentDetailsFormByFriday - проверка обработки данных на основании даты понедельник
 * testHandlePaymentDetailsFormBySaturday - проверка обработки данных на основании даты понедельник
 * testHandlePaymentDetailsFormBySunday - проверка обработки данных на основании даты понедельник
 * testHandlePaymentDetailsFormByMondayAndStandardTariff - проверка обработки данных на основании даты понедельник и
 *                                                          стандартного типа тарифа
 * testHandlePaymentDetailsFormByMondayAndAllInclusiveTariff - проверка обработки данных на основании даты понедельник и
 *                                                          тарифа все включено
 *
 * Created by Maksim Zagorodskiy on 7/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplication.class)
@WebAppConfiguration
public class PaymentDetailsHandlerTest {

    private static final Long MONDAY= 1468195200000L;
    private static final Long TUESDAY= 1468281600000L;
    private static final Long WEDNESDAY= 1468368000000L;
    private static final Long THURSDAY= 1468454400000L;
    private static final Long FRIDAY= 1468540800000L;
    private static final Long SATURDAY= 1468627200000L;
    private static final Long SUNDAY= 1468713600000L;

    private static final Integer ZIP_CODE_TO = 12333;
    private static final Integer ZIP_CODE_FROM = 12345;

    private static final Integer STANDARD = 1;
    private static final Integer ALL_INCLUSIVE = 1;

    private static final String HEAVY_ITEM = "item";

    private static final Double DISCOUNT = 20D;

    @Autowired
    private PaymentDetailsHandler paymentDetailsHandler;
    @Autowired
    private TariffRepository tariffRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Before
    public void prepareTariffs(){
        prepareLionsMoving();
    }

    @Test
    public void testHandlePaymentDetailsFormByMonday(){

        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(), MONDAY, STANDARD, 2, 1, 2, HEAVY_ITEM, 20D));
      //  Assert.assertEquals("Rate per hour is incorrect", BigDecimal.valueOf(24.4D), BigDecimal.valueOf(detailsDTO.getRatePerHour()));
    }
    @Test
    public void testHandlePaymentDetailsFormByTuesday(){
        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(), TUESDAY, STANDARD, 2, 1, 2, HEAVY_ITEM, 20D));
    }
    @Test
    public void testHandlePaymentDetailsFormByWednesday(){
        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(),WEDNESDAY, STANDARD, 2, 1, 2, HEAVY_ITEM, 20D));
    }
    @Test
    public void testHandlePaymentDetailsFormByThursday(){
        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(), THURSDAY, STANDARD, 2, 1, 2, HEAVY_ITEM, 20D));
    }
    @Test
    public void testHandlePaymentDetailsFormByFriday(){
        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(), FRIDAY, STANDARD, 2, 1, 2, HEAVY_ITEM, 20D));
    }
    @Test
    public void testHandlePaymentDetailsFormBySaturday(){
        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(), SATURDAY, STANDARD, 2, 1, 2, HEAVY_ITEM, 20D));
    }
    @Test
    public void testHandlePaymentDetailsFormBySunday(){
        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(), SUNDAY, STANDARD, 2, 1, 2, HEAVY_ITEM, 20D));
    }
    @Test
    public void testHandlePaymentDetailsFormByMondayAndStandardTariff(){
        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(), MONDAY, ALL_INCLUSIVE, 2, 1, 2, HEAVY_ITEM, 20D));
    }
    @Test
    public void testHandlePaymentDetailsFormByMondayAndAllInclusiveTariff(){
        PaymentDetailsDTO detailsDTO = paymentDetailsHandler.handlePaymentDetailsForm(preparePaymentDetailsFormByDay(
                Company.LIONS_MOVING.name(),MONDAY, ALL_INCLUSIVE, 2, 1, 2, HEAVY_ITEM, 20D));
    }

    public void prepareLionsMoving(){
        String companyName = Company.LIONS_MOVING.name();
        int standardTariff = TariffType.STANDARD.getType();
        int allInclusiveTariff = TariffType.ALL_INCLUSIVE.getType();

        Tariff preparedTariffStandard = fillStandardTariff(companyName, standardTariff);
        Tariff preparedTariffAllInclusive = fillAllInclusiveTariff(companyName, allInclusiveTariff);

        Tariff standard = tariffRepository.findByNameAndTariffType(companyName, allInclusiveTariff);
        Tariff allInclusive = tariffRepository.findByNameAndTariffType(companyName, allInclusiveTariff);

        if(standard == null) {
            tariffRepository.save(preparedTariffStandard);
        }
        if(allInclusive == null) {
            tariffRepository.save(preparedTariffAllInclusive);
        }
    }

    /**
     * Метод заполняет данные для стандартного тарифа.
     * @param companyName - имя компании
     * @param standardTariff - тип тарифа
     * @return подготовленные тариф
     */
    private Tariff fillStandardTariff(String companyName, int standardTariff) {
        Tariff preparedTariffStandard = new Tariff();
        preparedTariffStandard.setName(companyName);
        preparedTariffStandard.setTariffType(standardTariff);
        preparedTariffStandard.setTwoMoversPrice(75);
        preparedTariffStandard.setThreeMoversPrice(105);
        preparedTariffStandard.setFourMoversPrice(135);
        preparedTariffStandard.setFiveMoversPrice(165);
        preparedTariffStandard.setAdditionalTruckPrice(20.0);
        preparedTariffStandard.setCashPay(0);
        preparedTariffStandard.setNotCashPay(10.0);
        preparedTariffStandard.setPackingMaterials(0D);
        preparedTariffStandard.setServiceCharge(30);
        preparedTariffStandard.setShrinkWrap(39.99);
        preparedTariffStandard.setTape(4.99);
        preparedTariffStandard.setDayCategoryOne(0);
        preparedTariffStandard.setDayCategoryTwo(0);
        preparedTariffStandard.setDayCategoryThree(0);
        return preparedTariffStandard;
    }

    /**
     * Метод заполняет данные для тарифа "Все включено".
     * @param companyName - имя компании
     * @param allInclusiveTariff - тип тарифа
     * @return подготовленные тариф
     */
    private Tariff fillAllInclusiveTariff(String companyName, int allInclusiveTariff) {
        Tariff preparedTariffAllInclusive = new Tariff();
        preparedTariffAllInclusive.setName(companyName);
        preparedTariffAllInclusive.setTariffType(allInclusiveTariff);
        preparedTariffAllInclusive.setTwoMoversPrice(90);
        preparedTariffAllInclusive.setThreeMoversPrice(115);
        preparedTariffAllInclusive.setFourMoversPrice(155);
        preparedTariffAllInclusive.setFiveMoversPrice(185);
        preparedTariffAllInclusive.setAdditionalTruckPrice(20.0);
        preparedTariffAllInclusive.setCashPay(0);
        preparedTariffAllInclusive.setNotCashPay(10.0);
        preparedTariffAllInclusive.setServiceCharge(30);
        preparedTariffAllInclusive.setPackingMaterials(0D);
        preparedTariffAllInclusive.setShrinkWrap(0.0);
        preparedTariffAllInclusive.setTape(0.0);
        preparedTariffAllInclusive.setDayCategoryOne(0);
        preparedTariffAllInclusive.setDayCategoryTwo(0);
        preparedTariffAllInclusive.setDayCategoryThree(0);
        return preparedTariffAllInclusive;
    }

    /**
     * Подготовка первичный формы Payment Details для обработки
     * @param day- день недели, для проверки работы тарифов в зависимости от дня
     * @return подготовленную форму
     */
    private PaymentDetailsForm preparePaymentDetailsFormByDay(String companyName, Long day, int tariff,
                                                              int truckQuantity,
                                                              int shrink,
                                                              int tape,
                                                              String heavyItem,
                                                              double discount){
        DateTime dateTime = new DateTime(day);
        PaymentDetailsForm detailsForm = new PaymentDetailsForm();

        detailsForm.setRateType(Rate.RATE_PER_HOUR.name());
        detailsForm.setCompany(companyName);
        detailsForm.setMovers(2);
        detailsForm.setMoveDate(dateTime.toDate());
        detailsForm.setZipFrom(ZIP_CODE_FROM);
        detailsForm.setZipTo(ZIP_CODE_TO);
        detailsForm.setTariff(TariffType.getByIndex(tariff).name());
        detailsForm.setPaymentMethod(PaymentMethod.CASH.name());
        detailsForm.setTruck(truckQuantity);
        detailsForm.setShrink(shrink);
        detailsForm.setTape(tape);
        detailsForm.setHeavyItem(heavyItem);
        detailsForm.setDiscount(discount);
        return detailsForm;
    }
}
