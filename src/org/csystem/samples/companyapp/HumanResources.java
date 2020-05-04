package org.csystem.samples.companyapp;

public class HumanResources {
    //...
    public void payInsurance(Employee employee)
    {
        System.out.printf("Citizen Id:%s%n", employee.getCitizenId());
        System.out.printf("Name:%s%n", employee.getName());
        System.out.printf("Insurance amount:%f%n", employee.calculateInsurance());
    }
}
