package ru.mirea.lab27.task1and2and3;

import java.util.LinkedList;

public class HashTable {
    private static final int TABLE_SIZE = 100;
    private LinkedList<Entry>[] table;

    public HashTable() {
        hashtabInit();
    }

    private int hashtabHash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % TABLE_SIZE;
        }
        return hash;
    }

    public void hashtabInit() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void hashtabAdd(String key, String value) {
        int hash = hashtabHash(key);
        LinkedList<Entry> list = table[hash];
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        list.add(new Entry(key, value));
    }

    public String hashtabLookup(String key) {
        int hash = hashtabHash(key);
        LinkedList<Entry> list = table[hash];
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void hashtabDelete(String key) {
        int hash = hashtabHash(key);
        LinkedList<Entry> list = table[hash];
        list.removeIf(entry -> entry.key.equals(key));
    }

    private static class Entry {
        private String key;
        private String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}


