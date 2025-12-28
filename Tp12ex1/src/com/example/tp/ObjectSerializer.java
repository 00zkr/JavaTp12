package com.example.tp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ObjectSerializer {
	public static void serialize(List<Record> data, String path) throws IOException { 
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
	        oos.writeObject(data);
	    }
	}

	@SuppressWarnings("unchecked")
	public static List<Record> deserialize(String path) throws IOException, ClassNotFoundException {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
	        return (List<Record>) ois.readObject();
	    }
	}
}