package lesson11_Barhanova;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;

public class TestOtusAuthorizationData {
    private static final Logger logger = LogManager.getLogger(TestOtusAuthorizationData.class);


    @Test
    public void testOtusAutorizationAndPersonalDataCheck(){
        try {
            OtusAuthorization.OtusAutorizationAndAddPersonalData();
            logger.info("Тест №1. Пользователь вошел в личный кабинет и заполнил раздел личных данных");
        }catch (Exception e){
            logger.error("Тест №1. Пользователь не вошел в личный кабинет и(или) заполнил раздел личных данных неверно");
        }
        try {
            OtusAuthorization.checkOtusPersonalData();
            logger.info("Тест №2. Пользователь вошел в личный кабинет и проверил правильность заполнения раздела личных данных");
        } catch (Exception e){
            logger.error("Тест №2. Пользователь не вошел в личный кабинет и(или) правильность заполнения раздела личных данных не соотвествует заданному");
        }

    }
}

