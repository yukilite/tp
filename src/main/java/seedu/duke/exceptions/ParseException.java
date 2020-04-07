package seedu.duke.exceptions;

class ParseException extends Exception {
    private String command;

    public ParseException(String commandType) {
        this.command = commandType;
    }

    @Override
    public String getLocalizedMessage() {
        return "Please fill in date in right format: dd/mm/yyyy and time in the 24 hour format: hhmm";
    }
}
