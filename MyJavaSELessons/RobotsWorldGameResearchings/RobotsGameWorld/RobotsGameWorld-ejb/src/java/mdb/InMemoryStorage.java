/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Victor
 */
class InMemoryStorage {
    private static final List<String> storage = new CopyOnWriteArrayList<>();
    
    private InMemoryStorage() { }
    
    public static void add(String value) {
        storage.add(value);
    }
    
    public static List<String> getValues() {
        return new ArrayList<>(storage);
    }
}
