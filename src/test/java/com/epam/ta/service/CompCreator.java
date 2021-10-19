package com.epam.ta.service;

import com.epam.ta.model.Computer;

public class CompCreator {

    private static final String NUMBER_OF_INSTANCES = "number.of.instances";
    private static final String OPERATING_SYSTEM = "operating.system";
    private static final String MACHINE_CLASS = "machine.class";
    private static final String MACHINE_TYPE = "machine.type";
    private static final String NUMBER_OF_GPU = "number.of.gpu";
    private static final String SERIES = "series";
    private static final String GPU_TYPE = "gpu.type";
    private static final String LOCAL_SSD = "local.ssd";
    private static final String DATACENTER_LOCATION = "datacenter.location";
    private static final String COMMITTED_USACH = "commited.usach";

    public static Computer createProductComputerEngine() {
        return new Computer(TestDataReader.getTestData(NUMBER_OF_INSTANCES), TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(MACHINE_CLASS), TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU), TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(GPU_TYPE), TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION), TestDataReader.getTestData(COMMITTED_USACH));
    }
}
