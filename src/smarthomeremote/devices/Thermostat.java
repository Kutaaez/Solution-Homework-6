package smarthomeremote.devices;

public class Thermostat {
    private int currentTemperature;
    private int previousTemperature;

    public Thermostat() {
        this.currentTemperature = 20; // Default temperature
    }

    public void setTemperature(int temperature) {
        this.previousTemperature = this.currentTemperature;
        this.currentTemperature = temperature;
        System.out.println("[Thermostat] Setting temperature to " + temperature + "°C");
    }

    public void revertTemperature() {
        this.currentTemperature = this.previousTemperature;
        System.out.println("[Thermostat] Reverting to previous temperature " + this.currentTemperature + "°C");
    }
}