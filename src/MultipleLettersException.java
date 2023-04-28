public class MultipleLettersException extends Exception{

    @Override
    public String getMessage(){
        String errorMsg = "More than one letter was entered";
        return errorMsg;
    }
}
//