package bugs;

import java.io.*;

/**
 * please provide 2 fix - variants
 */
public class SerializableExceptionP2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("test_empls");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Empl empls[] = new Empl[]{new Empl("n1", "n1"), new Empl("n2", "n2"), new Empl("n3", "n3"), null};

        for (Empl empl : empls) {
            objectOutputStream.writeObject(empl);
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


class Manager implements Serializable {
    private String companyName;

    public Manager(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}

class Empl extends Manager implements Serializable {
    private String name;
    private String surName;

    public Empl(String name, String surName) {
        super("companyName");
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
        return "Empl{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
