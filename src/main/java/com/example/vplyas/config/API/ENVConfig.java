package com.example.vplyas.config.API;

import io.github.cdimascio.dotenv.Dotenv;

public class ENVConfig {

  public static void loadEnv() {
    Dotenv dotenv = Dotenv.configure().load();

    String host = dotenv.get("MYSQL_DB_HOST");
    String port = dotenv.get("MYSQL_DB_PORT");
    String user = dotenv.get("MYSQL_DB_USERNAME");
    String password = dotenv.get("SQL_ROOT_PASSWORD");
    String db = dotenv.get("MYSQL_DB_DB");
    String keyStorePassword = dotenv.get("KEYSTORE_PASSWORD");

    System.setProperty("MYSQL_DB_HOST", host);
    System.setProperty("MYSQL_DB_PORT", port);
    System.setProperty("MYSQL_DB_USERNAME", user);
    System.setProperty("SQL_ROOT_PASSWORD", password);
    System.setProperty("MYSQL_DB_DB", db);
    System.setProperty("KEYSTORE_PASSWORD", keyStorePassword);
  }

}
