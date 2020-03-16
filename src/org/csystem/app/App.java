/*----------------------------------------------------------------------------------------------------------------------
    Taxi, Driver ve Client sınıfları arasındaki ilişkiler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Client client1 = new Client(/*...*/);
        Client client2 = new Client(/*...*/);
        Driver driver = new Driver(/*...*/);
        Taxi taxi = new Taxi(driver/*...*/);

        taxi.take(client1);

        taxi.take(client2);

        Driver driver2 = new Driver(/*...*/);

        taxi.setDriver(driver2);

        taxi.take(client1);
    }
}

class Taxi {
    //...
    private Driver m_driver;

    public Taxi(Driver driver)
    {
        m_driver = driver;
    }

    public Driver getDriver()
    {
        return m_driver;
    }

    public void setDriver(Driver driver)
    {
        m_driver = driver;
    }

    public void take(Client client)
    {
        //...
    }
}

class Driver {
    //...
}

class Client {
    //...
}

