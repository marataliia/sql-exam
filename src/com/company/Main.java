package com.company;

public class Main {

    public static void main(String[] args) {
    DbWorker dbWorker = new DbWorker();
    dbWorker.addNews("Elon Musk's new cybertruck", "Elon Musk says the bizarre-looking new Cybertruck from Tesla was 'inspired by games like Halo");
    dbWorker.addNews("Justin Bieber released new album", "Justin Bieber's new album 'Cahnges' is on top billboard");
    dbWorker.updateNews("a", "b", 2);
    dbWorker.deleteNews(2);

    }
}
