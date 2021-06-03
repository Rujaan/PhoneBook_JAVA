public class NumberException extends Exception
{
    public String toString(){
        return "Please enter a number between 0 and 8";
    }

    public String getMessage(){
        return "Invalid Input";
    }
}
