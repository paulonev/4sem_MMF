package by.bsu.phonesUtilizer.fileReader;

import by.bsu.phonesUtilizer.entity.Phone;
import by.bsu.phonesUtilizer.entity.PhoneProducers;
import by.bsu.phonesUtilizer.exceptions.InvalidHardwareParametersException;
import by.bsu.phonesUtilizer.validator.PhoneValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneReader {

    /**This method reads string by string from file and
     * if data is valid, creates list of phones
     *
     * @param filePath    the file where data is stored
     * @return            list of valid phones or exceptions
     * @throws IOException                          if problems with reader occurs and if path in the argument doesn't match any real
     * @throws IllegalArgumentException             if producer is not valid
     * @throws NumberFormatException                if try to parse "str" to int or double
     * @throws InvalidHardwareParametersException   if data from file is wrong(ex: ROM = -1)
     */
    public List<Phone> readFromFile(String filePath) throws IOException,IllegalArgumentException,
                                                            NumberFormatException, InvalidHardwareParametersException {

        List<Phone> phones = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Map<String, Integer> phoneKeyMap = new HashMap<>();

        //create indexes for object fields
        if (reader.ready()) {
            String[] phoneKeys = reader.readLine().split(",");
            int counter = 0;
            for (String key : phoneKeys) {
                phoneKeyMap.put(key, counter++);
            }
        } else {
            return phones;
        }

        //to read strings with phones from file
        //phoneKeyMap.get - returns an index
        while (reader.ready()) {

            String[] phoneValues = reader.readLine().split(",");
            String phoneProducerStr = phoneValues[phoneKeyMap.get("producer")];
            double phonePrice = Double.parseDouble(phoneValues[phoneKeyMap.get("price")]);
            int phoneYearRelease = Integer.parseInt(phoneValues[phoneKeyMap.get("yearRelease")]);
            int phoneROMcapacity = Integer.parseInt(phoneValues[phoneKeyMap.get("ROM")]);
            int phoneRAMcapacity = Integer.parseInt(phoneValues[phoneKeyMap.get("RAM")]);
            int phoneBATcapacity = Integer.parseInt(phoneValues[phoneKeyMap.get("battery")]);
            double phoneCAMresolution = Double.parseDouble(phoneValues[phoneKeyMap.get("camera")]);

            if (PhoneValidator.isPhoneValid(phonePrice, phoneYearRelease, phoneROMcapacity,
                    phoneRAMcapacity, phoneBATcapacity, phoneCAMresolution)) {

                PhoneProducers phoneProducer = PhoneProducers.valueOf(phoneProducerStr.toUpperCase());
                Phone phone = new Phone(phoneProducer, phonePrice, phoneYearRelease,phoneROMcapacity,
                                        phoneRAMcapacity, phoneBATcapacity, phoneCAMresolution);

                phones.add(phone);
            }
            else throw new InvalidHardwareParametersException("File contains invalid hardware parameters. Check and redo resource file");
        }
        return phones;
    }
}
