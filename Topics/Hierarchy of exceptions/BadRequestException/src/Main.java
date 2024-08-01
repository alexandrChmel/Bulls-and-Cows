class BadRequestException extends Exception{
    String message;
    BadRequestException(String message){
        super(message);
        this.message = message;
    }
}