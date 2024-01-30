package com.example.vplyas.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

  @GetMapping("/css/{code}.css")
  public ResponseEntity<String> styles(@PathVariable("code") String code) throws IOException {
    // получаем содержимое файла из папки ресурсов в виде потока
    InputStream is = getClass().getClassLoader().getResourceAsStream("static/css/" + code + ".css");
    // преобразуем поток в строку
    BufferedReader bf = new BufferedReader(new InputStreamReader(is));
    StringBuffer sb = new StringBuffer();
    String line = null;
    while ((line = bf.readLine()) != null) {
      sb.append(line + "\n");
    }

    // создаем объект, в котором будем хранить HTTP заголовки
    final HttpHeaders httpHeaders = new HttpHeaders();
    // добавляем заголовок, который хранит тип содержимого
    httpHeaders.add("Content-Type", "text/css; charset=utf-8");
    // возвращаем HTTP ответ, в который передаем тело ответа, заголовки и статус 200 Ok
    return new ResponseEntity<String>(sb.toString(), httpHeaders, HttpStatus.OK);
  }

  @GetMapping("/js/{code}.js")
  public ResponseEntity<String> js(@PathVariable("code") String code) throws IOException {
    // получаем содержимое файла из папки ресурсов в виде потока
    InputStream is = getClass().getClassLoader().getResourceAsStream("static/js/" + code + ".js");
    // преобразуем поток в строку
    BufferedReader bf = new BufferedReader(new InputStreamReader(is));
    StringBuffer sb = new StringBuffer();
    String line = null;
    while ((line = bf.readLine()) != null) {
      sb.append(line + "\n");
    }

    // создаем объект, в котором будем хранить HTTP заголовки
    final HttpHeaders httpHeaders = new HttpHeaders();
    // добавляем заголовок, который хранит тип содержимого
    httpHeaders.add("Content-Type", "text/javascript; charset=utf-8");
    // возвращаем HTTP ответ, в который передаем тело ответа, заголовки и статус 200 Ok
    return new ResponseEntity<String>(sb.toString(), httpHeaders, HttpStatus.OK);
  }

  @GetMapping("/png/{code}.png")
  public ResponseEntity<String> png(@PathVariable("code") String code) throws IOException {

    InputStream is = getClass().getClassLoader().getResourceAsStream("static/png/" + code + ".png");

    BufferedReader bf = new BufferedReader(new InputStreamReader(is));
    StringBuffer sb = new StringBuffer();
    String line = null;
    while ((line = bf.readLine()) != null) {
      sb.append(line + "\n");
    }

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "multipart/form-data; boundary=something");
    return new ResponseEntity<String>(sb.toString(), httpHeaders, HttpStatus.OK);
  }
}
