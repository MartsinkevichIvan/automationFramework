package com.epam.ta.model;

import java.util.Objects;

public class Computer {

    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String machineType;
    private String numberOfGpu;
    private String series;
    private String gpuType;
    private String localSsd;
    private String datacenterLocation;
    private String commitedUsage;

    public Computer(String numberOfInstances, String operatingSystem, String machineClass, String machineType,
                    String numberOfGpu, String series, String gpuType, String localSsd, String datacenterLocation,
                    String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.numberOfGpu = numberOfGpu;
        this.series = series;
        this.gpuType = gpuType;
        this.localSsd = localSsd;
        this.datacenterLocation = datacenterLocation;
        this.commitedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGpu() {
        return numberOfGpu;
    }

    public void setNumberOfGpu(String numberOfGpu) {
        this.numberOfGpu = numberOfGpu;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGpu='" + numberOfGpu + '\'' +
                ", series='" + series + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(numberOfInstances, computer.numberOfInstances) &&
                Objects.equals(operatingSystem, computer.operatingSystem) &&
                Objects.equals(machineClass, computer.machineClass) &&
                Objects.equals(machineType, computer.machineType) &&
                Objects.equals(numberOfGpu, computer.numberOfGpu) &&
                Objects.equals(series, computer.series) &&
                Objects.equals(gpuType, computer.gpuType) &&
                Objects.equals(localSsd, computer.localSsd) &&
                Objects.equals(datacenterLocation, computer.datacenterLocation) &&
                Objects.equals(commitedUsage, computer.commitedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, machineClass, machineType, numberOfGpu, series, gpuType, localSsd, datacenterLocation, commitedUsage);
    }
}
