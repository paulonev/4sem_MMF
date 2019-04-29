package by.bsu.phonesUtilizer.entity;

import java.util.Objects;

/** Main entities of this app (Phone and inner class PhoneHardware)
 *
 * @author Paul Okunev
 * @version 1.0
 */

public class Phone {
    private PhoneProducers producer;
    private double price;
    private int yearRelease;
    private PhoneHardware phoneHardware;

    public Phone() {}

    public Phone(PhoneProducers producer, double price, int yearRelease) {
        this.producer = producer;
        this.price = price;
        this.yearRelease = yearRelease;
    }

    public Phone(String producer, double price, int yearRelease,int ROMcapacity, int RAMcapacity,
                 int BATTERYcapacity, double CAMresolution){
        this.producer = PhoneProducers.valueOf(producer.toUpperCase());
        this.price = price;
        this.yearRelease = yearRelease;
        this.phoneHardware = new PhoneHardware(ROMcapacity,RAMcapacity,BATTERYcapacity,CAMresolution);

    }

    public Phone(PhoneProducers producer, double price, int yearRelease,int ROMcapacity, int RAMcapacity,
                 int BATTERYcapacity, double CAMresolution){
        this.producer = producer;
        this.price = price;
        this.yearRelease = yearRelease;
        this.phoneHardware = new PhoneHardware(ROMcapacity,RAMcapacity,BATTERYcapacity,CAMresolution);

    }

    public PhoneHardware getPhoneHardware(){
        return this.phoneHardware;
    }

    @Override
    public String toString() {
        return "PHONE{" +
                "producer=" + producer +
                ", price=" + price +
                ", yearRelease=" + yearRelease +
                ", phoneHardware=" + phoneHardware +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Double.compare(phone.price, price) == 0 &&
                yearRelease == phone.yearRelease &&
                producer == phone.producer &&
                Objects.equals(phoneHardware, phone.phoneHardware);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, price, yearRelease, phoneHardware);
    }

    public class PhoneHardware {
        int ROMcapacity;
        int RAMcapacity;
        int BATTERYcapacity;
        double CAMresolution;

        public PhoneHardware(int ROMcapacity, int RAMcapacity, int BATTERYcapacity, double CAMresolution) {
            this.ROMcapacity = ROMcapacity;
            this.RAMcapacity = RAMcapacity;
            this.BATTERYcapacity = BATTERYcapacity;
            this.CAMresolution = CAMresolution;
        }

        public int getROMcapacity() {
            return ROMcapacity;
        }

        public int getRAMcapacity() {
            return RAMcapacity;
        }

        public int getBATTERYcapacity() {
            return BATTERYcapacity;
        }

        public double getCAMresolution() {
            return CAMresolution;
        }

        @Override
        public String toString() {
            return "PHONE_HARDWARE{" +
                    "\nROMcapacity=" + ROMcapacity +
                    ",\nRAMcapacity=" + RAMcapacity +
                    ",\nBATTERYcapacity=" + BATTERYcapacity +
                    ",\nCAMresolution=" + CAMresolution +
                    "\n}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PhoneHardware that = (PhoneHardware) o;
            return ROMcapacity == that.ROMcapacity &&
                    RAMcapacity == that.RAMcapacity &&
                    BATTERYcapacity == that.BATTERYcapacity &&
                    Double.compare(that.CAMresolution, CAMresolution) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ROMcapacity, RAMcapacity, BATTERYcapacity, CAMresolution);
        }
    }
}
