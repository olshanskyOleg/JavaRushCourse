package com.javarush.task.pro.task09.task0912;

/* 
Проверка URL-адреса
*/

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        String[] splitUrl = url.split("//");
        if (splitUrl.length>0){
            if ((splitUrl[0].trim().equals("https:"))||(splitUrl[0].trim().equals("http:"))){
                return splitUrl[0].trim().replace(":","");
            }
        }
        return "неизвестный";
    }

    public static String checkDomain(String url) {
        String[] splitUrl = url.split("//");
        String extendes = "com|net|org|ru|";
        if (splitUrl.length>0){
            int indexOfDomain = splitUrl.length == 1 ?  0: 1;

            int i = splitUrl[indexOfDomain].lastIndexOf(".");
            if (i>=0&&i<splitUrl[indexOfDomain].length()){
                String ext = splitUrl[indexOfDomain].substring(i+1).trim();
                if (extendes.indexOf(ext+"|")>=0){
                    return ext;
                }

            }
        }
        return "неизвестный";
    }
}
