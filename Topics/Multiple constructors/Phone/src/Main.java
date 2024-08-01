class Phone {

    String ownerName;
    String countryCode;
    String cityCode;
    String number;
    Phone(String ownerName, String number){
        this.ownerName = ownerName;
        this.number = number;
    }
    Phone(String ownerName, String number, String cityCode, String countryCode){
        this.ownerName = ownerName;
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }
}