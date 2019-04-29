package by.bsu.phonesUtilizer.validator;

import static by.bsu.phonesUtilizer.constants.PhoneValidityConstants.*;

public class PhoneValidator {
    public static boolean isPhoneValid(double phonePrice, int phoneYearRelease, int phoneROMcapacity,
                                       int phoneRAMcapacity, int phoneBATcapacity, double phoneCAMresolution) {

        return !(phoneYearRelease < MIN_YEAR_PHONE_RELEASE || phoneYearRelease > MAX_YEAR_PHONE_RELEASE ||
                phoneROMcapacity <= MIN_ROM_CAPACITY || phonePrice < MIN_PHONE_PRICE ||  phoneRAMcapacity <= MIN_RAM_CAPACITY ||
                phoneBATcapacity <= MIN_BAT_CAPACITY || phoneCAMresolution <= MIN_CAM_RESOLUTION);
    }
}
