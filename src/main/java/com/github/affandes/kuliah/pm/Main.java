package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main{
    private Stack<String> history = new Stack<>();

    // Fungsi browse: menambah website baru ke history
    public void browse(String website) {
        history.push(website);
        System.out.println("Browsing: " + website);
    }

    // Fungsi back: kembali ke website sebelumnya
    public void back() {
        if (history.size() > 1) {
            String removed = history.pop();
            System.out.println("Back from: " + removed);
            System.out.println("Current: " + history.peek());
        } else if (history.size() == 1) {
            System.out.println("Tidak bisa back! Hanya ada 1 website di history.");
        } else {
            System.out.println("History kosong!");
        }
    }

    // Fungsi view: menampilkan seluruh history dari paling baru
    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong!");
            return;
        }

        System.out.println("\n=== Browser History (Newest → Oldest) ===");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main browser = new Main();

        while (true) {
            System.out.println("\nCommand: browse <url> | back | view | exit");
            System.out.print("> ");
            String input = sc.nextLine();

            if (input.startsWith("browse ")) {
                String url = input.substring(7).trim();
                browser.browse(url);
            } else if (input.equals("back")) {
                browser.back();
            } else if (input.equals("view")) {
                browser.view();
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("Command tidak dikenal.");
            }
        }

        sc.close();
    }
}
