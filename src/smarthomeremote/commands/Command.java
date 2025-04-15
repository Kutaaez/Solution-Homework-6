package smarthomeremote.commands;

public interface Command {
    void execute();
    void undo();
}