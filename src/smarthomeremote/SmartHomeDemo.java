package smarthomeremote;

import smarthomeremote.commands.TurnOffLightCommand;
import smarthomeremote.commands.TurnOnLightCommand;
import smarthomeremote.devices.Light;
import smarthomeremote.devices.Thermostat;
import smarthomeremote.commands.Command;
import smarthomeremote.commands.SetThermostatCommand;
import smarthomeremote.commands.MacroCommand;
import smarthomeremote.invoker.SmartHomeRemoteControl;

import java.util.Arrays;
import java.util.Scanner;

public class SmartHomeDemo {
    public static void main(String[] args) {
        // create devices
        Light livingRoomLight = new Light("Living Room");
        Thermostat thermostat = new Thermostat();

        // create commands
        Command turnOnLight = new TurnOnLightCommand(livingRoomLight);
        Command turnOffLight = new TurnOffLightCommand(livingRoomLight);
        Command setThermostat = new SetThermostatCommand(thermostat, 22);
        Command goodnightMode = new MacroCommand(Arrays.asList(
                new TurnOffLightCommand(livingRoomLight),
                new SetThermostatCommand(thermostat, 18)
        ));

        // Set up remote
        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand(1, turnOnLight);
        remote.setCommand(2, turnOffLight);
        remote.setCommand(3, setThermostat);
        remote.setCommand(4, goodnightMode);

        // CLI Menu
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSmart Home Remote Control");
            System.out.println("1. Turn On Light");
            System.out.println("2. Turn Off Light");
            System.out.println("3. Set Thermostat to 22°C");
            System.out.println("4. Goodnight Mode");
            System.out.println("5. Undo");
            System.out.println("6. Redo");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    remote.pressButton(1);
                    break;
                case 2:
                    remote.pressButton(2);
                    break;
                case 3:
                    remote.pressButton(3);
                    break;
                case 4:
                    remote.pressButton(4);
                    break;
                case 5:
                    remote.undoButton();
                    break;
                case 6:
                    remote.redoButton();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
