package bugs;

import java.io.*;

public class SerializableExceptionP1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("test_users");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        User users[] = new User[]{new User("n1", "n1"), new User("n2", "n2"), new User("n3", "n3"), null};

        for (User user : users) {
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
        }
        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object o = null;
        while ((o = objectInputStream.readObject()) != null) {
            System.out.println(o);
        }
        fileInputStream.close();
        objectInputStream.close();


    }
}

class User implements Serializable {
    private String name;
    private String surName;

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
