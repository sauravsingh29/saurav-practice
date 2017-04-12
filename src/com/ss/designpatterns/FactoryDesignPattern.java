package com.ss.designpatterns;

/**
 * This sample code is for Factory Design Pattern example. It falls under creational design pattern
 */

interface Database {
    void createConnection();
}

/**
 * Created by Saurav on 11-04-2017.
 */
public class FactoryDesignPattern {
    public static void main(String[] args) {
        DbFactory dbFactory = new DbFactory();
        Database database = dbFactory.getDb("MySql");
        database.createConnection();
        database = dbFactory.getDb("Oracle");
        database.createConnection();
    }
}

class DbFactory {

    public Database getDb(final String dbName) {
        switch (dbName) {
            case "MySql":
                return new MySql();
            case "Postgres":
                return new Postgres();
            case "Oracle":
                return new Oracle();
            default:
                return null;
        }
    }
}

class MySql implements Database {
    @Override
    public void createConnection() {
        System.out.println("MySql database connection created!");
    }
}

class Postgres implements Database {

    @Override
    public void createConnection() {
        System.out.println("Postgres database connection created!");
    }
}

class Oracle implements Database {
    @Override
    public void createConnection() {
        System.out.println("Oracle database connection created!");
    }
}